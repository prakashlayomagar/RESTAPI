import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.service.UserService;

@RestController 
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService ;
	}

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
       Optional<User> user = userService.getUserById(id);
       return user.orElse(null);
    }

}
