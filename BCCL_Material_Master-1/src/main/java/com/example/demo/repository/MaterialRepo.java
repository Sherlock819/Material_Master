package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.MaterialEntity;

@RepositoryRestResource(collectionResourceRel="material",path="material")
public interface MaterialRepo extends JpaRepository<MaterialEntity, Integer> {

}
