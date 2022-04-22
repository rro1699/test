package com.example.netcackerapp.repo;

import com.example.netcackerapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
