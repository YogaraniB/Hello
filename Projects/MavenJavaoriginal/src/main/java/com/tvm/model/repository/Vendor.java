package com.tvm.model.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Vendor {

	@Id
	
	private int vendorid;
	private String name;
	private String address;
	private String mailId;
	private String contactno;
	public int getvendorid() {
		return vendorid;
	}
	public void setvendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Vendor(int vendorid, String name, String address, String mailId, String contactno) {
		super();
		this.vendorid = vendorid;
		this.name = name;
		this.address = address;
		this.mailId = mailId;
		this.contactno = contactno;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
