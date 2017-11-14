package com.store.details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gunDetails")
public class GunDetails {
	@Id
	@GeneratedValue
	@Column(name = "User_ID", nullable = false)
	private int id;
	@Column(name = "Gun_name")
	private String gunName;
	@Column(name = "Holder_name")
	private String holderName;
	@Column(name = "Gun_model")
	private int gunModel;
	@Column(name = "Gun_Serial_number", unique = true, nullable = false)
	private long serialNumber;
	@Column(name = "Gun_type")
	private String type;
	@Column(name = "Shooting_range", nullable = false)
	private float range;
	@Column(name = "Gun_weight", nullable = false)
	private float weight;

	public GunDetails(int id, String gunName, String holderName, int gunModel, long serialNumber, String type,
			float range, float weight) {
		this.id = id;
		this.gunName = gunName;
		this.holderName = holderName;
		this.gunModel = gunModel;
		this.serialNumber = serialNumber;
		this.type = type;
		this.range = range;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGunName() {
		return gunName;
	}

	public void setGunName(String gunName) {
		this.gunName = gunName;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getGunModel() {
		return gunModel;
	}

	public void setGunModel(int gunModel) {
		this.gunModel = gunModel;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
}
