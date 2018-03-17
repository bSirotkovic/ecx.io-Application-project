package io.ecx.data;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.ecx.Pokemon;

public class PokemonDAO {

	private MongoDatabase mongodb;
	
	public PokemonDAO() {
		mongodb = new MongoDatabaseManager().getDatabase();
	}
	
	public void addPokemon(Pokemon pokemon) {
		MongoCollection<Document> col = mongodb.getCollection("Pokemon");
		
		col.insertOne(pokemon.getDocumentRepresentation());
	}
	
	public ArrayList<Pokemon> getAllPokemons() {
		MongoCollection<Document> col = mongodb.getCollection("Pokemon");
		ArrayList<Pokemon> toReturn = new ArrayList<>();
		
		for(Document curDoc : col.find(new Document())) {
			toReturn.add(new Pokemon(curDoc));
		}
		
		return toReturn;
	}
	
	public Pokemon getSpecificPokemon(int id) {
		MongoCollection<Document> col = mongodb.getCollection("Pokemon");
		
		Document queryDoc = new Document("id", id);
		Document result = col.find(queryDoc).first();
		return new Pokemon(result);
	}
}
