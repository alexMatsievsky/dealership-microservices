package com.cars.repository;

import com.cars.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
//    @Modifying
//    void insertMyEntity(@Param("name") String name, @Param("age") int age);
//    @Query("INSERT INTO MyEntity (name, age) VALUES (:name, :age)")
//public Optional<CustomerEntity> saveCustomer(CustomerEntity customerEntity);
}
