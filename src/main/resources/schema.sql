CREATE TABLE CLIENT (
                        id BIGINT NOT NULL,
                        name VARCHAR(100),
                        PRIMARY KEY (id)
);

CREATE TABLE SERVICE (
                         id BIGINT NOT NULL,
                         price FLOAT NOT NULL,
                         name VARCHAR(255),
                         PRIMARY KEY (id)
);

CREATE TABLE RESERVATION (
                             id BIGINT NOT NULL,
                             date DATE,
                             price FLOAT NOT NULL,
                             client_id BIGINT,
                             service_id BIGINT,
                             PRIMARY KEY (id),
                             FOREIGN KEY (client_id) REFERENCES CLIENT(id),
                             FOREIGN KEY (service_id) REFERENCES SERVICE(id)
);

INSERT INTO CLIENT (id, name) VALUES ( '1', 'Anna Kowalska' );
INSERT INTO CLIENT (id, name) VALUES ( '2', 'Kamil Kowalski' );

INSERT INTO SERVICE (id, price, name) VALUES ( '1', '60.00', 'Motorower' );
INSERT INTO SERVICE (id, price, name) VALUES ( '2', '70.00', 'Motocykl' );
INSERT INTO SERVICE (id, price, name) VALUES ( '3', '110.00', 'Samochód osobowy do 3,5t' );
INSERT INTO SERVICE (id, price, name) VALUES ( '4', '150.00', 'TAXI' );
INSERT INTO SERVICE (id, price, name) VALUES ( '5', '160.00', 'Samochód przeznaczony do nauki jazdy');
