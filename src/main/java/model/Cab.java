package model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String company;
    String carModel;
    @Enumerated(EnumType.ORDINAL.STRING)
    CarType carType;
    int numberOfSeats;
    double farePerKm;

    Driver driver;

}
