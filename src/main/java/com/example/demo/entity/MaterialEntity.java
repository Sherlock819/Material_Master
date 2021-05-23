package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MaterialEntity {
	
	@Id
	private int materialId;
	private String materialName;
	private int availableUnits;

	
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public int getAvailableUnits() {
		return availableUnits;
	}
	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}
	
}
