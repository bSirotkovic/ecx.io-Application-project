package io.ecx;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import io.ecx.data.PokemonDAO;

public class Trainer {
	
	public int id;
	public String firstName;
	public String lastName;
	public List<Integer> pokemonIDs;
	public List<Pokemon> pokemons;
	
	public Trainer() {
		this(0, "Ash", "Ketchum", null);
	}

	public Trainer(int id, String firstName, String lastName, List<Integer> pokemonIDs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		if(pokemonIDs == null) {
			this.pokemonIDs = new ArrayList<Integer>();
		} else {
			this.pokemonIDs = pokemonIDs;			
		}
	}

	@SuppressWarnings("unchecked")
	public Trainer(Document doc) {
		this.id = doc.getInteger("id");
		this.firstName = doc.getString("firstName");
		this.lastName = doc.getString("lastName");
		this.pokemonIDs = (List<Integer>) doc.get("pokemonIDs");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Integer> getPokemonIDs() {
		return pokemonIDs;
	}

	public void setPokemons(List<Integer> pokemonIDs) {
		this.pokemonIDs = pokemonIDs;
	}

	public Document getDocumentRepresentation() {
		Document doc = new Document();
		doc.append("id", id);
		doc.append("firstName", firstName);
		doc.append("lastName", lastName);
		doc.append("pokemonIDs", pokemonIDs);
		return doc;
	}

	public void getPokemonInfo(PokemonDAO pokemonDAO) {
		if(pokemons == null) {
			pokemons = new ArrayList<Pokemon>();
		}
		for (Integer pokemonID : pokemonIDs) {
			Pokemon curPokemon = pokemonDAO.getSpecificPokemon(pokemonID);
			if(curPokemon != null) pokemons.add(curPokemon);
		}
	}
	
	
}
