package ma.fstt.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ma.fstt.model.Utilisateur;


public interface Utilisateurrepository extends MongoRepository<Utilisateur,String> {


}
