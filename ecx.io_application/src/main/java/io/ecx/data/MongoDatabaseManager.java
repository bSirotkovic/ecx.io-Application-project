package io.ecx.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseManager {

	MongoClient mongoClient;
	
	public MongoDatabaseManager() {
		init();
	}
	
	private void init() {
		mongoClient = new MongoClient("localhost", 27017);	
	}

	public MongoDatabase getDatabase() {
		if(mongoClient == null) init();
		
		return mongoClient.getDatabase("PokemonDatabase");
	}
}
