package com.myimplementation.splitwise.repository;

import com.myimplementation.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByNameAndPhone(String name,long phone);
}
