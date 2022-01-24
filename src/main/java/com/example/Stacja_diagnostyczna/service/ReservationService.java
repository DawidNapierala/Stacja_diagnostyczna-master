package com.example.Stacja_diagnostyczna.service;

import com.example.Stacja_diagnostyczna.entity.Client;
import com.example.Stacja_diagnostyczna.entity.Reservation;
import com.example.Stacja_diagnostyczna.entity.Serwis;
import com.example.Stacja_diagnostyczna.repository.ClientRepository;
import com.example.Stacja_diagnostyczna.repository.ReservationRepository;
import com.example.Stacja_diagnostyczna.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ServiceRepository serviceRepository;

    public List<Serwis> listAllServices() {
        return serviceRepository.findAll();
    }

    public List<Serwis> getAvailableServices(LocalDate date) {
        List<Long> ExcludedIds = serviceRepository.getAllServicesBooked(date);

        if(ExcludedIds.isEmpty()) //jeżeli wszystkie usługi dostępne w terminie
            return serviceRepository.findAll(); //wypisz wszystkie
        else
            return serviceRepository.findAllByIdNotIn(ExcludedIds); //wypisz tylko dostępne w terminie
    }

    public Optional<Serwis> findServiceById(Long id) {return serviceRepository.findById(id);}

    public float CalculateServicePrices(float ServicePrice){
        return ServicePrice;
    }

    public Reservation createReservation(String ClientName, LocalDate date, Long ServiceId){
        Reservation r = new Reservation();

        Client c = new Client();
        c.setName(ClientName);
        c = clientRepository.save(c);

        Optional<Serwis> service = serviceRepository.findById(ServiceId);

        r.setClient(c);
        r.setDate(date);
        r.setPrice(CalculateServicePrices(service.get().ServicePrice));
        r.setService(service.get());

        return reservationRepository.save(r);
    }

    public Optional<Reservation> getReservationById(Long Id) {return reservationRepository.findById(Id);}

}
