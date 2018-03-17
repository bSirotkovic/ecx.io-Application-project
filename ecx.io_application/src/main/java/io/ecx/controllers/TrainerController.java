package io.ecx.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.ecx.Trainer;
import io.ecx.data.PokemonDAO;
import io.ecx.data.TrainerDAO;

@Controller
public class TrainerController {

	@RequestMapping(value = "/trainer", method = RequestMethod.GET)
	public String getAllPokemons(Model model) {
		TrainerDAO trainerDAO = new TrainerDAO();
		ArrayList<Trainer> listOfTrainers = trainerDAO.getAllTrainers();
		
		for (Trainer trainer : listOfTrainers) {
			trainer.getPokemonInfo(new PokemonDAO());
		}
		
		model.addAttribute("list", listOfTrainers);
		return "trainer";
	}
	
	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.GET)
	public String getSpecificTrainer(@PathVariable("id") int id, Model model) {
		TrainerDAO trainerDAO = new TrainerDAO();
		ArrayList<Trainer> list = new ArrayList<Trainer>();
		Trainer specificTrainer = trainerDAO.getSpecificTrainer(id);
		specificTrainer.getPokemonInfo(new PokemonDAO());
		list.add(specificTrainer);
		
		model.addAttribute("list", list);
		return "trainer";
	}
	
	@RequestMapping(value = "/addtrainer", method = RequestMethod.GET)
	public String addNewPokemon(Model model) {
		model.addAttribute("trainer", new Trainer());
		return "addTrainer";
	}
	
	@RequestMapping(value = "/trainer", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Trainer trainer) {
		TrainerDAO trainerDAO = new TrainerDAO();
		trainerDAO.addTrainer(trainer);
		
		return "result";
	}
}
