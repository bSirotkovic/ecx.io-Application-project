package io.ecx.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.ecx.Pokemon;
import io.ecx.data.PokemonDAO;

@Controller
public class PokemonController {

	@RequestMapping(value = "/pokemon", method = RequestMethod.GET)
	public String getAllPokemons(Model model) {
		PokemonDAO pokemonDAO = new PokemonDAO();
		
		model.addAttribute("list", pokemonDAO.getAllPokemons());
		return "pokemon";
	}
	
	@RequestMapping(value = "/pokemon/{id}", method = RequestMethod.GET)
	public String getSpecificPokemon(@PathVariable("id") int id, Model model) {
		PokemonDAO pokemonDAO = new PokemonDAO();
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		list.add(pokemonDAO.getSpecificPokemon(id));
		
		model.addAttribute("list", list);
		return "pokemon";
	}
	
	@RequestMapping(value = "/addpokemon", method = RequestMethod.GET)
	public String addNewPokemon(Model model) {
		model.addAttribute("pokemon", new Pokemon());
		return "addPokemon";
	}
	
	@RequestMapping(value = "/pokemon", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Pokemon pokemon) {
		PokemonDAO pokemonDAO = new PokemonDAO();
		pokemonDAO.addPokemon(pokemon);
		
		return "result";
	}
}
