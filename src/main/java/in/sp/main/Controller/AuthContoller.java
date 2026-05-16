package in.sp.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Services.UserService;
import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthContoller {
	
	  @Autowired
	    private UserService userService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @PostMapping("/register")
	    public User register(@RequestBody User user){

	        return userService.registerUser(user);

	    }


}
