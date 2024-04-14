package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String source;
    String destination;

    double tripDistanceInKm;
    double totalFare;

    TripStatus tripStatus;

    @CreationTimestamp
    Date bookedAt;
}
