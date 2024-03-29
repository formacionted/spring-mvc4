package com.telefonica.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.spring.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	Movie findByName(String name);
}
