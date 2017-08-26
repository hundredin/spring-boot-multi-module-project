package com.spring.core.repository;

import com.spring.core.domain.QUser;
import com.spring.core.domain.User;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

	public UserRepositoryImpl(){
		super(User.class);
	}

	@Override
	public List<User> findCustom(String name) {

		QUser qUser = QUser.user;

		List<User> users = from(qUser)
				.where(qUser.name.eq(name))
				.fetch();

		return users;
	}
}
