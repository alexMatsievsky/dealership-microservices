package com.cars.repository.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "customer")
public class CustomerEntity extends AuditEntity{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;
    @Column(length=50, nullable=false, unique=true)
    String email;
    @Column(length=50, nullable=false)
    String firstName;
    @Column(length=50, nullable=false)
    String lastName;
    @Column(length=50, nullable=false)
    String password;
}
