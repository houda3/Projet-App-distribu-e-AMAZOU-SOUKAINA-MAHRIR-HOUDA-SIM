package ma.fstt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ma.fstt.model.KMeans1;
import ma.fstt.model.User;
import ma.fstt.repository.KMeanRep;
import ma.fstt.repository.UserRepository;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class ProjetApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	private KMeanRep kmeans;

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	    User u1= new User(1,"houda","houda","houda",22,"1234");
	    userRepository.save(u1);
	    
	    System.out.println("***********");

		int clusterNumber = 2;
		KMeans1 demo = new KMeans1();
		demo.genereateRecord();
		demo.initiateClusterAndCentroid(clusterNumber);
		demo.printRecordInformation();
		demo.printClusterInformation();
		
		
	}

}

