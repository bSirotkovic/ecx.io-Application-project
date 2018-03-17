package io.ecx;

import org.bson.Document;

public class Pokemon {

	public int id;
	public String name;
	public String type;
	
	public Pokemon(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public Pokemon() {
		
	}

	public Pokemon(Document doc) {
		this.id = doc.getInteger("id");
		this.name = doc.getString("name");
		this.type = doc.getString("type");
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Document getDocumentRepresentation() {
		Document doc = new Document();
		doc.append("id", id);
		doc.append("name", name);
		doc.append("type", type);
		return doc;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
