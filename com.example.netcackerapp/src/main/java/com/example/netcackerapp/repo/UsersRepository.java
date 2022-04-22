package com.example.netcackerapp.repo;

import com.example.netcackerapp.Models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Integer> {
}
