package com.telefonica.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Director implements Serializable{

	private static final long serialVersionUID = 1L;
	// atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer activeYears;
	private Integer age;
	
	// asociaciones
	@OneToMany(mappedBy = "director")
	List<Movie> movies = new ArrayList<>();
	
	public Director() {}
	public Director(String name, Integer activeYears, Integer age) {
		this.name = name;
		this.activeYears = activeYears;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getActiveYears() {
		return activeYears;
	}
	public void setActiveYears(Integer activeYears) {
		this.activeYears = activeYears;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	
	
}
