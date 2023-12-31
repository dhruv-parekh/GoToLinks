package com.dareProjects.gotoLinks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dareProjects.gotoLinks.beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByEmail(String email);
	
}
