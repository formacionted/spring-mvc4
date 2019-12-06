package com.telefonica.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telefonica.spring.model.Director;
import com.telefonica.spring.repository.DirectorRepository;

@Controller
public class DirectorController {

	@Autowired
	private DirectorRepository directorRepository;
	
	@GetMapping("/directors")
	public ModelAndView getAllMovies() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("movie-list"); // indica la vista
//		mav.addObject("movies", movieRepository.findAll()); // obtiene el modelo
//		return mav;
		return new ModelAndView("director-list", "directors", directorRepository.findAll());
	}
	
//	@GetMapping("/directors/empty")
//	public ModelAndView createMovie() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("director-edit");
//		mav.addObject("director", new Movie());
//		mav.addObject("movies", directorRepository.findAll());
//		return mav;
//	}
	
	@PostMapping("/directors")
	public String saveMovie(@ModelAttribute("director") Director director) {
		
		if (director.getId() == null) {
			// crear
			directorRepository.save(director);
		}else {
			// editar
			Director directorDB = directorRepository.findById(director.getId()).get();
			directorDB.setName(director.getName());
			directorDB.setAge(director.getAge());
			directorDB.setActiveYears(director.getActiveYears());
			directorRepository.save(directorDB);
		}
		return "redirect:/directors";
	}
	/**
	 * Recupera una movie por su id
	 * @param id
	 * @return
	 */
	@GetMapping("/directors/{id}")
	public ModelAndView getDirector(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView();
		Optional<Director> directorOpt = directorRepository.findById(id);
		if (!directorOpt.isPresent()) {
			mav.setViewName("director-list");
			mav.addObject("directors", directorRepository.findAll());
		}else {
			mav.setViewName("director-edit");
			mav.addObject("director", directorOpt.get());
			mav.addObject("directors", directorRepository.findAll());
		}
		return mav;
	}
//
//	@GetMapping("/movies/{id}/delete")
//	public String removeMovie(@PathVariable Long id) {
//		movieRepository.deleteById(id);
//		return "redirect:/movies";
//	}
	
}
