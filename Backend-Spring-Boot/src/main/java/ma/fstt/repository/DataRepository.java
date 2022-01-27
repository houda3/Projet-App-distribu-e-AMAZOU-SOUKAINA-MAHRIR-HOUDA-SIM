package ma.fstt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ma.fstt.model.Data;


public interface DataRepository extends MongoRepository<Data, String> {

}
