package com.example.netcackerapp.repo;

import com.example.netcackerapp.Models.Places;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Places,Integer> {
}
