package com.example.RideIt.model;

import com.example.RideIt.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String source;
    String destination;

    double tripDistanceInKm;
    double totalFare;

    TripStatus tripStatus;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;
}
