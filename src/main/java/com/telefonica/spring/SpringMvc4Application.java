package com.telefonica.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telefonica.spring.model.Director;
import com.telefonica.spring.model.Movie;
import com.telefonica.spring.model.User;
import com.telefonica.spring.repository.DirectorRepository;
import com.telefonica.spring.repository.MovieRepository;
import com.telefonica.spring.repository.UserRepository;

@SpringBootApplication
public class SpringMvc4Application implements CommandLineRunner{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvc4Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Director director1 = 
				directorRepository.save(new Director("Bilall Fallah", 10, 32));
		Director director2 = 
				directorRepository.save(new Director("Will smith", 10, 32));
		
		Movie movie1 = new Movie("Bad Boys III", 2020, "ACCIÓN", "badboys.jpg");
		movie1.setDirector(director1);
		
		movieRepository.save(movie1);
		
		User user1 = new User();
		user1.setEmail("alan");
		user1.setPassword("alan");
		userRepository.save(user1);
		
	}

}
