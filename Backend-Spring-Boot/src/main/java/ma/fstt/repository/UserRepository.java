package ma.fstt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ma.fstt.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	public User findByUsername(String username);

	public Iterable<User> deleteByUsername(String username);
}
