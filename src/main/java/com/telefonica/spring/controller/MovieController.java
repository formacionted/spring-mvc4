package com.telefonica.spring.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.telefonica.spring.model.Movie;
import com.telefonica.spring.repository.DirectorRepository;
import com.telefonica.spring.repository.MovieRepository;


@Controller
public class MovieController {

	private final Logger log = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/movies";
	}

	@GetMapping("/movies")
	public ModelAndView getAllMovies() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("movie-list"); // indica la vista
//		mav.addObject("movies", movieRepository.findAll()); // obtiene el modelo
//		return mav;
		return new ModelAndView("movie-list", "movies", movieRepository.findAll());
	}

	@GetMapping("/movies/empty")
	public ModelAndView createMovie() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("movie-edit");
		mav.addObject("movie", new Movie());
		mav.addObject("directors", directorRepository.findAll());
		return mav;
	}
	
//	@PostMapping("/movies")
	@RequestMapping(value="/movies", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		
		if (movie.getId() == null) {
			// crear
			movieRepository.save(movie);
		}else {
			// editar
			Movie movieDB = movieRepository.findById(movie.getId()).get();
			movieDB.setName(movie.getName());
			movieDB.setAge(movie.getAge());
			movieDB.setDirector(movie.getDirector());
			movieDB.setGenre(movie.getGenre());
			movieRepository.save(movieDB);
		}
		return "redirect:/movies";
	}

	/**
	 * Recupera una movie por su id
	 * @param id
	 * @return
	 */
	@GetMapping("/movies/{id}")
	public ModelAndView getMovie(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		Optional<Movie> movieOpt = movieRepository.findById(id);
		if (!movieOpt.isPresent()) {
			mav.setViewName("movie-list");
			mav.addObject("movies", movieRepository.findAll());
		}else {
			mav.setViewName("movie-edit");
			mav.addObject("movie", movieOpt.get());
			mav.addObject("directors", directorRepository.findAll());
		}
		return mav;
	}

	@GetMapping("/movies/{id}/delete")
	public String removeMovie(@PathVariable Long id) {
		movieRepository.deleteById(id);
		return "redirect:/movies";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
