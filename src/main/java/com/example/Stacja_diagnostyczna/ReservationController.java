package com.example.Stacja_diagnostyczna;

import com.example.Stacja_diagnostyczna.entity.Reservation;
import com.example.Stacja_diagnostyczna.entity.Serwis;
import com.example.Stacja_diagnostyczna.service.ReservationService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/")
    public String home(
            @RequestParam(value = "date", required = false) String DateString, Model model
    ) {
        if (DateString != null) {
            LocalDate Date = LocalDate.parse(DateString);

            model.addAttribute("date", Date.toString());

            //List<Serwis> services = reservationService.getAvailableServices(Date);

            model.addAttribute("services", reservationService.listAllServices());
        }
        return "index";
    }

    @GetMapping("/reservations")
    public String home2(Model model) {

        model.addAttribute("reservations", reservationService.listAllReservations());

        return"reservations";
}

    @GetMapping("/reserve-service/{id}")
    public String reserveService(
            @PathVariable Long id, @RequestParam(value = "date", required = false) String DateString, Model model
    ){
        model.addAttribute("date", DateString);
        model.addAttribute("serviceid", id);

        Optional<Serwis> serwis = reservationService.findServiceById(id);

        if(serwis.isPresent()){
            float reservationPrice = reservationService.CalculateServicePrices(
                    serwis.get().ServicePrice
            );
            model.addAttribute("reservationprice", reservationPrice);
            model.addAttribute("servicename", serwis.get().ServiceName);

            return "reservation";
        }

        return "redirect:/";
    }

    @PostMapping("/reservation-confirm1")
    public String reservationConfirm(
            @RequestParam("client_name") String ClientName,
            @RequestParam("date") String DateString,
            @RequestParam("serviceid") Long ServiceId
    ){
        LocalDate Date = LocalDate.parse(DateString);
        Reservation reservation = reservationService.createReservation(ClientName, Date, ServiceId);
        return "redirect:/reservation-confirm"+reservation.getId();
    }

    @GetMapping("/reservation-confirm/{id}")
    public String reservationConfirmPage(@PathVariable Long id, Model model){
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if(reservation.isPresent()){
            model.addAttribute("reservation", reservation.get());
            return "reservation-confirm";
        }
        return "redirect:/";
    }

}
