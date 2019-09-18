package com.example.socialNetwork.repository;

import com.example.socialNetwork.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
