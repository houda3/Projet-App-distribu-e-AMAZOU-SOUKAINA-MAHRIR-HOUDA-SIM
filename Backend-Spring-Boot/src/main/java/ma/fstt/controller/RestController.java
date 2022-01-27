package ma.fstt.controller;

import javax.servlet.http.HttpServletRequest; 
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ma.fstt.model.User;
import ma.fstt.service.UserService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")

public class RestController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user, HttpServletRequest request) {
		userService.saveMyUser(user);
		return "Hello "+user.getFirstname()+", your registration is successful!";
	}
	
	@GetMapping("/all-users")
	public Iterable<User> showAllUsers() {
		return userService.showAllUsers();
	}
	
	@GetMapping("/delete/{username}")
	public Iterable<User> deleteUser(@PathVariable String username){
		return userService.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	public User searchUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}
}
