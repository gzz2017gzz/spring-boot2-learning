package com.gzz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("find")
	public User find() {
		User user = new User();
		user.setId(1);
		user.setName("李四");
		return user;
	}

}
