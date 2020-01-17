package com.gzz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gzz.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllByUsername(String username);
}
