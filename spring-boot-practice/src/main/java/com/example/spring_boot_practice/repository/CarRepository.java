package com.example.spring_boot_practice.repository;

import com.example.spring_boot_practice.annotation.TrackTime;
import com.example.spring_boot_practice.dto.CarResponseDTO;
import com.example.spring_boot_practice.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @TrackTime
    List<Car> findAll();

    @TrackTime
    @Query("SELECT c FROM Car c")
    Page<Car> findAllWithPage(Pageable pageable);

    @TrackTime
    @Query("SELECT c FROM Car c")
    Page<Car> findAllWithPageable(Pageable pageable);


}
