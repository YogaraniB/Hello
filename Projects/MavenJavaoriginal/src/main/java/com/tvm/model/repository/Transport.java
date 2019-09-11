package com.tvm.model.repository;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transport {

	@Id
	
	private long id;
	private String drivername;
	private String vehicle;
	private Long mobile;
	private String destination;
	private String address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Transport(long id, String drivername, String vehicle, Long mobile, String destination, String address) {
		super();
		this.id = id;
		this.drivername = drivername;
		this.vehicle = vehicle;
		this.mobile = mobile;
		this.destination = destination;
		this.address = address;
	}
	public Transport() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}