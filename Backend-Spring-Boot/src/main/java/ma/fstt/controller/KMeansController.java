package ma.fstt.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.fstt.model.KMeans1;

import ma.fstt.repository.KMeanRep;

@CrossOrigin
@RestController
public class KMeansController {
	@Autowired
	
	private KMeanRep kmean;
	
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/kmeans")
public void Kmeans(@RequestBody KMeans1 demo) {
		//int clusterNumber = 3;
		//demo.genereateRecord();
		//demo.initiateClusterAndCentroid(clusterNumber);
		//demo.printRecordInformation();
		//demo.printClusterInformation();
		kmean.save(demo);
	}
	@GetMapping("/findKmeans")
	
public List<KMeans1> getKameans(){
	return kmean.findAll();
}
	

}
