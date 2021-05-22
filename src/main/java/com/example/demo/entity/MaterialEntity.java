package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MaterialEntity {
	
	@Id
	private int materialId;
	private String materialName;
	private int availableUnits;

}
