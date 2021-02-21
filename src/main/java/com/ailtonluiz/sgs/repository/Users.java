package com.ailtonluiz.sgs.repository;

import com.ailtonluiz.sgs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Integer> {
    User findByName(String name);
}
