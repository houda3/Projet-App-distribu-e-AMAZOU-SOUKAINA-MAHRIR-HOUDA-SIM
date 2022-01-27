package ma.fstt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Document(collection="KMeans")
public class KMeans1 {

	List<Record> data = new ArrayList<Record>();
	List<Cluster> clusters = new ArrayList<Cluster>();
	Map<Cluster, List<Record>> clusterRecords = new HashMap<Cluster, List<Record>>();
	
	/*public static void main(String[] args) {
		
		int clusterNumber = 2;
		KMeans1 demo = new KMeans1();
		demo.genereateRecord();
		demo.initiateClusterAndCentroid(clusterNumber);
		demo.printRecordInformation();
		demo.printClusterInformation();
	}*/
	
	public KMeans1(List<Record> data, List<Cluster> clusters, Map<Cluster, List<Record>> clusterRecords) {
		super();
		this.data = data;
		this.clusters = clusters;
		this.clusterRecords = clusterRecords;
	}

	public KMeans1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void genereateRecord() {
		

		Record record = new Record(1, 5.1, 3.5, 1.4,0.2,"Iris-setosa");
		data.add(record);
		record = new Record(2, 4.9, 3, 1.4,0.2,"Iris-setosa");
		data.add(record);
		record = new Record(3, 5, 2, 3.5,1,"Iris-versicolor");
		data.add(record);
		record = new Record(4, 5.9, 3, 4.2,1.5,"Iris-versicolor");
		data.add(record);
		record = new Record(5, 6.3, 3.3, 6, 2.5,"Iris-virginica");
		data.add(record);
		record = new Record(6, 5.8, 2.7, 5.1,1.9,"Iris-virginica");
		data.add(record);
		
	}

	public void initiateClusterAndCentroid(int clusterNumber) {
		int counter = 1;
		Iterator<Record> iterator = data.iterator();
		Record record = null;
		
		while(iterator.hasNext()) {
			record = iterator.next();
			if(counter <= clusterNumber) {
				record.setClusterNumber(counter);
				initializeCluster(counter, record);
				counter++;
			}else {
				System.out.println(record);
				System.out.println("** Cluster Information **");
				for(Cluster cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println("*********************");
                double minDistance = Integer.MAX_VALUE;
                Cluster whichCluster = null;
                
                for(Cluster cluster : clusters) {
                	double distance = cluster.calculateDistance(record);
                	System.out.println(distance);
                	if(minDistance > distance) {
                		minDistance = distance;
                		whichCluster = cluster;
                	}
                }
                
                record.setClusterNumber(whichCluster.getClusterNumber());
				whichCluster.updateCentroid(record);
				clusterRecords.get(whichCluster).add(record);

			}
			
			System.out.println("** Cluster Information **");
			for(Cluster cluster : clusters) {
				System.out.println(cluster);
			}
			System.out.println("*********************");

			
		}

	}

	private void initializeCluster(int clusterNumber, Record record) {
		
		Cluster cluster = new Cluster(clusterNumber,record.getSepallength(),record.getSepalwidth(),record.getPetallength());
		clusters.add(cluster);
		List<Record> clusterRecord = new ArrayList<Record>();
		clusterRecord.add(record);
		clusterRecords.put(cluster, clusterRecord);

	}

	public void printRecordInformation() {
		   System.out.println("****** Each Record INFORMATIN *********");
		   for(Record record : data) {
			   System.out.println(record);
		   }
	   }

	public void printClusterInformation() {
	   System.out.println("****** FINAL CLUSTER INFORMATIN *********");
	   for (Map.Entry<Cluster, List<Record>> entry : clusterRecords.entrySet())  {
        System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue()); 
    }
}


}