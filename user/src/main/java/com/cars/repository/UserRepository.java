package com.cars.repository;

import com.cars.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
//    @Modifying
//    void insertMyEntity(@Param("name") String name, @Param("age") int age);
//    @Query("INSERT INTO MyEntity (name, age) VALUES (:name, :age)")
//public Optional<CustomerEntity> saveCustomer(CustomerEntity customerEntity);
}
