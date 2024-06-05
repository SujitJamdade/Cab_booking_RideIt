package com.example.RideIt.model;

import com.example.RideIt.Enum.CarType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String company;
    String cabNo;
    String carModel;
    @Enumerated(EnumType.STRING)
    CarType carType;
    int numberOfSeats;
    double farePerKm;

    @OneToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

}
