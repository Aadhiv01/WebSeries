package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebSeriesController {
	
	//Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Autowired
	WebSeriesRepository repo;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Details");
		return mv;
	}
	
	@PostMapping("/addSeries")
	public void addSeries(WebSeries ws) {
		repo.save(ws);
	}

	@GetMapping("/series/id/{id}")
	@ResponseBody
	public Optional<WebSeries> getSeriesById(@PathVariable int id) {
		return repo.findById(id);
	}
	
	@GetMapping("/series/name/{name}")
	@ResponseBody
	public WebSeries getSeriesByName(@PathVariable String name) {
		return repo.findByName(name); 
	}
	
	@GetMapping("/series")
	@ResponseBody
	public List<WebSeries> getAllSeries() {
		return repo.findAll(); 
	}
	
	@PutMapping("/update")
	public void updateSeries(WebSeries ws) {
		/*WebSeries new_ws = repo.findById(ws.getId()).orElse(new WebSeries());
		new_ws.setEpisodes(ws.getEpisodes());
		new_ws.setName(ws.getName());
		new_ws.setRating(ws.getRating());
		new_ws.setSeasons(ws.getSeasons());*/
		repo.save(ws);
		System.out.println("ws update");
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String deleteSeries(@PathVariable int id) {
		repo.deleteById(id);
		return "Series Removed ! "+id;
	}
}
