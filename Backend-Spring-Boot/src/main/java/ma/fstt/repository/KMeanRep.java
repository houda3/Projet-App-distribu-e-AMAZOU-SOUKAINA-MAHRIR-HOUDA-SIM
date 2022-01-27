package ma.fstt.repository;
import ma.fstt.model.KMeans1;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KMeanRep  extends MongoRepository<KMeans1,String> {

}
