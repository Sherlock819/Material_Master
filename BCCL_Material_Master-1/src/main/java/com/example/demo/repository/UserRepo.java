package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.UserEntity;

@RepositoryRestResource(collectionResourceRel="user",path="user")
public interface UserRepo extends JpaRepository<UserEntity, String> {
	
}

