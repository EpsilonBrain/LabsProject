package com.hcc.repositories;

import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this is an example repository feel free to delete this once you have created your own.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //what you are expecting to output
    //what you need it to take in
    Optional<User> findByUsername(String username);
}
