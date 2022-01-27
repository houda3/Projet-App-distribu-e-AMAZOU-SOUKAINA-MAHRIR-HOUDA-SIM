package ma.fstt.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="irisdata")

public class Record {
	
	@Id
	private int id;
	private double sepallength;
	private double sepalwidth;
	private double petallength;
	private double petalwidth;
	private String classification;
	private int clusterNumber;
	
	protected Record(int id, double sepallength, double sepalwidth, double petallength, double petalwidth, String classification) {
		super();
		this.id = id;
		this.sepallength = sepallength;
		this.sepalwidth = sepalwidth;
		this.petallength = petallength;
		this.petalwidth = petalwidth;
		this.classification = classification;
	}
	protected Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSepallength() {
		return sepallength;
	}
	public void setSepallength(int sepallength) {
		this.sepallength = sepallength;
	}
	public double getSepalwidth() {
		return sepalwidth;
	}
	public void setSepalwidth(int sepalwidth) {
		this.sepalwidth = sepalwidth;
	}
	public double getPetallength() {
		return petallength;
	}
	public void setPetallength(int petallength) {
		this.petallength = petallength;
	}
	public double getPetalwidth() {
		return petalwidth;
	}
	public void setPetalwidth(int petalwidth) {
		this.petalwidth = petalwidth;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", sepallength=" + sepallength + ", sepalwidth=" + sepalwidth + ", petallength="
				+ petallength + ", petalwidth=" + petalwidth + ", classification=" + classification + ", clusterNumber="
				+ clusterNumber + "]";
	}
	

	


	

}
