package com.madhan.test.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EMP_TBL", schema = "BMS")
@Access(AccessType.FIELD)


public class Employee {
	@Id
	@Column(name = "ENO")
	private Integer eno;
	@Column(name = "NAME")
	private String ename;
	@Column(name = "SALARY")
	private Double esalary;
   


	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getEsalary() {
		return esalary;
	}

	public void setEsalary(Double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", esalary=" + esalary + "]";
	}

}
