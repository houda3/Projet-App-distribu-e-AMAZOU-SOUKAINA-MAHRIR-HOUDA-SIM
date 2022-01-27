package ma.fstt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ma.fstt.model.IrisData;

public interface IrisRep extends  MongoRepository<IrisData,String>{

}
