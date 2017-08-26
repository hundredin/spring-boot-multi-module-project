package com.spring.core.service;

import com.spring.core.domain.User;
import com.spring.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;

	@Override
	@Transactional
	public void testService() {
		User user = new User("foobar");
		userRepository.save(user);

		List<User> users = userRepository.findByName("foobar");
		System.out.println(users);

	}
}
