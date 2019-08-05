package com.asminds.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employeenew")
public class Emloyee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	 private int empid;
	 private String empname;
	 private String empaddress;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public Emloyee(int empid, String empname, String empaddress) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empaddress = empaddress;
	}
	public Emloyee() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
}
