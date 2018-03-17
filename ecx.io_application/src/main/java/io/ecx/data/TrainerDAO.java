package io.ecx.data;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import io.ecx.Trainer;

public class TrainerDAO {

private MongoDatabase mongodb;
	
	public TrainerDAO() {
		mongodb = new MongoDatabaseManager().getDatabase();
	}
	
	public void addTrainer(Trainer trainer) {
		MongoCollection<Document> col = mongodb.getCollection("Trainer");
		
		col.insertOne(trainer.getDocumentRepresentation());
	}
	
	public ArrayList<Trainer> getAllTrainers() {
		MongoCollection<Document> col = mongodb.getCollection("Trainer");
		ArrayList<Trainer> toReturn = new ArrayList<>();
		
		for(Document curDoc : col.find(new Document())) {
			toReturn.add(new Trainer(curDoc));
		}
		
		return toReturn;
	}
	
	public Trainer getSpecificTrainer(int id) {
		MongoCollection<Document> col = mongodb.getCollection("Trainer");
		
		Document queryDoc = new Document("id", id);
		Document result = col.find(queryDoc).first();
		return new Trainer(result);
	}
}
