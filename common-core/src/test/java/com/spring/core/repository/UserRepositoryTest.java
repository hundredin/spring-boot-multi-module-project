package com.spring.core.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.spring.core.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class UserRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@DatabaseSetup("classpath:dbunit/User.xml")
	public void findByName() {
		List<User> result = userRepository.findByName("foo");
		assertThat(result).hasSize(1).extracting("name").contains("foo");
	}

	@Test
	@DatabaseSetup("classpath:dbunit/User.xml")
	public void findCustom() {
		List<User> result = userRepository.findCustom("bar");
		assertThat(result).hasSize(1).extracting("name").contains("bar");
	}

	@Test
	public void saveAndFind() {
        String name = "jason";

        User user = new User(name);
		userRepository.save(user);

		User foundUser = userRepository.findOne(user.getId());

		assertThat(foundUser.getName()).isEqualTo(name);
	}
}
