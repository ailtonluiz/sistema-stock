package com.ailtonluiz.sgs.repository;

import com.ailtonluiz.sgs.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Companies extends JpaRepository<Company, Integer> {
}
