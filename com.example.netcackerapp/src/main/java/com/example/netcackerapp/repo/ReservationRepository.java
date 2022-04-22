package com.example.netcackerapp.repo;

import com.example.netcackerapp.Models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}
