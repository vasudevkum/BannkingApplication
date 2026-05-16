package in.sp.main.Services;

import org.springframework.stereotype.Service;

import in.sp.main.entity.User;

@Service
public interface UserService {

	   User registerUser(User user);

}
