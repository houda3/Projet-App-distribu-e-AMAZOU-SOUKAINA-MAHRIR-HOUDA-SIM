package ma.fstt.model;

public class Cluster {

	private double sepallengthCentroid;
	private double sepalwidthCentroid;
	private double petallengthCentroid;
	private int clusterNumber;
	
	
	
	public Cluster(int clusterNumber, double SepallengthCentroid, double sepalwidthCentroid, double petallengthCentroid) {
		super();
		this.clusterNumber = clusterNumber;
		this.sepallengthCentroid = sepallengthCentroid;
		this.sepalwidthCentroid = sepalwidthCentroid;
		this.petallengthCentroid = petallengthCentroid;
	}
	
	public double getSepallengthCentroid() {
		return sepallengthCentroid;
	}
	public void setSepallengthCentroid(double sepallengthCentroid) {
		this.sepallengthCentroid = sepallengthCentroid;
	}
	public double getSepalwidthCentroid() {
		return sepalwidthCentroid;
	}
	public void setSepalwidthCentroid(double sepalwidthCentroid) {
		this.sepalwidthCentroid = sepalwidthCentroid;
	}
	public double getPetallengthCentroid() {
		return petallengthCentroid;
	}
	public void setPetallengthCentroid(double petallengthCentroid) {
		this.petallengthCentroid = petallengthCentroid;
	}
	public int getClusterNumber() {
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber) {
		this.clusterNumber = clusterNumber;
	}

	@Override
	public String toString() {
		return "Cluster [sepallengthCentroid=" + sepallengthCentroid + ", sepalwidthCentroid=" + sepalwidthCentroid + ", petallengthCentroid="
				+ petallengthCentroid + ", clusterNumber=" + clusterNumber + "]";
	}
	
	// Euclidean distance calculation
	public double calculateDistance(Record record) {
		return Math.sqrt(Math.pow((getSepallengthCentroid() - record.getPetalwidth()), 2) + Math.pow((getSepalwidthCentroid() - record.getSepalwidth()),2) + Math.pow((getPetallengthCentroid() - record.getPetallength()), 2));
    }

	// Binod Suman Academy YouTube Video on K-Mean Algorithm
	public void updateCentroid(Record record) {
		setSepallengthCentroid((getSepallengthCentroid()+record.getSepallength())/2);
		setSepalwidthCentroid((getSepalwidthCentroid()+record.getSepalwidth())/2);
		setPetallengthCentroid((getPetallengthCentroid()+record.getPetallength())/2); 
	}

}