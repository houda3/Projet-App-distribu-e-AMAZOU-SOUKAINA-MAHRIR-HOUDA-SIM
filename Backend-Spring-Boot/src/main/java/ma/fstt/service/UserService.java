package ma.fstt.service;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.fstt.model.User;
import ma.fstt.repository.UserRepository;


@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public void saveMyUser(User user ) {
		userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			users.add(user);
		}
		
		return users;
	}
	
	public Iterable<User> deleteUserByUsername(String username) {
		userRepository.deleteByUsername(username);
		return userRepository.findAll();
	}
	
	public Optional<User> editUser(int id) {
		return userRepository.findById(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public User findByUsernameAndPassword(String username, String password) {
		return ((UserService) userRepository).findByUsernameAndPassword(username, password);
	}
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}
	
	}

	