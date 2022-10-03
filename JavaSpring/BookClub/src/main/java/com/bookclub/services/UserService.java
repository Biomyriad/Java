package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookclub.models.LoginCreds;
import com.bookclub.models.User;
import com.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
    public List<User> allUsers() {
        return userRepository.findAll();
    }
    
    public User findUser(Long id) {
		return userRepository.findById(id).orElse(null);
    }
    
    public User createUser(User b) {
        return userRepository.save(b);
    }
    
    public User updateUser(User b) {
        return userRepository.save(b);
    }
    
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    public User register(User userInfo, BindingResult result) {
    	Optional<User> userQuery = userRepository.findByEmail(userInfo.getEmail());
    	
    	if(userQuery.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	
    	if(!userInfo.getPassword().equals(userInfo.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    
    	String hashed = BCrypt.hashpw(userInfo.getPassword(), BCrypt.gensalt());
    	userInfo.setPassword(hashed);
    	return userRepository.save(userInfo);    	

    }
    
    public User login(LoginCreds login, BindingResult result) {
    	
    	Optional<User> userQuery = userRepository.findByEmail(login.getEmail());
        
    	if(!userQuery.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	User user = userQuery.get();
        
    	if(!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        return user;    	

    }

}
