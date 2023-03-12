package com.cars.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "customer")
public class CustomerEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(length=50, nullable=false, unique=true)
    String email;
    @Column(length=50, nullable=false)
    String firstNa;
    @Column(length=50, nullable=false)
    String lastNa;
    @Column(length=50, nullable=false)
    String password;
}
