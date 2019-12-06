package com.telefonica.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.spring.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
}
