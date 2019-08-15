package edu.mum.cs.cs425.finalproject.senteapp.repository;

import edu.mum.cs.cs425.finalproject.senteapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    public User findByUsernameEquals(String name);


}
