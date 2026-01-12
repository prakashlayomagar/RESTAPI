package net.javaguides.springboot.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.api.model.User;

@Service
public class UserService {

    private List<User> userList;
     
    public UserService() {
        userList = new ArrayList<>();
        loadUsersFromJson();
    }

    private void loadUsersFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/data/users.json")) {
            if (is != null) {
                List<User> users = mapper.readValue(is, new TypeReference<List<User>>() {});
                userList.addAll(users);
            }
        } catch (IOException e) {
            // if reading fails, keep empty list; log if desired
            e.printStackTrace();
        }
    }
    
    public Optional<User> getUser(Integer id){
        for(User user: userList) {
            if (id != null && id.equals(user.getId())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    public synchronized void addUser(User user) {
        // assign id if missing or zero
        int newId = 1;
        for (User u : userList) {
            if (u.getId() >= newId) newId = u.getId() + 1;
        }
        if (user.getId() == 0) {
            user.setId(newId);
        }
        userList.add(user);
        writeUsersToJson();
    }

    private void writeUsersToJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("src/main/resources/data/users.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
