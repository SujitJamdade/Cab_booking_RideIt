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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;

    @Column(unique = true, nullable = false)
    String emailId;

    String address;
    @Enumerated(EnumType.STRING)
    Gender gender;
}
