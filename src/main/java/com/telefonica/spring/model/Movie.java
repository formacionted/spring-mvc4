package com.telefonica.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private String genre;
	private String img;
	
	// asociaciones
	@ManyToOne()
	@JoinColumn(name = "id_director")
	private Director director;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	
	public Movie() {}

	public Movie(String name, Integer age, String genre, String img) {
		super();
		this.name = name;
		this.age = age;
		this.genre = genre;
		this.img = img;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
