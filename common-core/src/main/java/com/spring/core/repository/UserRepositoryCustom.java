package com.spring.core.repository;

import com.spring.core.domain.User;

import java.util.List;

public interface UserRepositoryCustom {
	List<User> findCustom(String name);
}
