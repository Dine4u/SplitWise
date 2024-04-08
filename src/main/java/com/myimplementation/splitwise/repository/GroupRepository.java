package com.myimplementation.splitwise.repository;

import com.myimplementation.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    Optional<Group> findById(int groupId);
}
