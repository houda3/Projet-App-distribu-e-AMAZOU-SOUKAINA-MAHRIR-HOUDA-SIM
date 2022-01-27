package ma.fstt.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="irisdata")
public class IrisData {
	 @Id
	 private String id;
	 private double sepallength;
	 private double sepalwidth;
	 private double petallength;
	 private double petalwidth;
	 private String classification;

	public IrisData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IrisData(double sepallength, double sepalwidth, double petallength, double petalwidth,
			String classification) {
		super();
		id = UUID.randomUUID().toString();;
		this.sepallength = sepallength;
		this.sepalwidth = sepalwidth;
		this.petallength = petallength;
		this.petalwidth = petalwidth;
		this.classification = classification;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = UUID.randomUUID().toString();
	}

	public double getSepallength() {
		return sepallength;
	}

	public void setSepallength(double sepallength) {
		this.sepallength = sepallength;
	}

	public double getSepalwidth() {
		return sepalwidth;
	}

	public void setSepalwidth(double sepalwidth) {
		this.sepalwidth = sepalwidth;
	}

	public double getPetallength() {
		return petallength;
	}

	public void setPetallength(double petallength) {
		this.petallength = petallength;
	}

	public double getPetalwidth() {
		return petalwidth;
	}

	public void setPetalwidth(double petalwidth) {
		this.petalwidth = petalwidth;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	 


}
