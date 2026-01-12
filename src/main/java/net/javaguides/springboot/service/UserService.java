package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.api.model.User;

@Service
public class UserService {

    private List<User> userList;
     
    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1, "John Doe",32,"john.doe@example.com"));
        userList.add(new User(2, "Jane Smith",28,"jane.smith@example.com"));
        userList.add(new User(3, "Bob Johnson",45,"bob.johnson@example.com"));
        userList.add(new User(4, "Alice Brown",22,"alice.brown@example.com"));
    
    }
    
    public Optional<User> getUser(Integer id){
    	Optional <User> optional = Optional.empty();
    	for(User user: userList) {
    		if (id == user.getId()) {
    			optional = Optional.of(user);
    			return optional;
    		}
    	}
		return optional;
    	
    }

}