package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.UserVerification;

@RepositoryRestResource(collectionResourceRel="userVerification",path="userVerification")
public interface UserVerificationRepo extends JpaRepository<UserVerification, String>{

}
