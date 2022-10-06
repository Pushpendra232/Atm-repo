package com.Atm.ATM;

//import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // this annotation is to create database by using this name mention in below 

//POjo class
    public class AtmPojo
 {
	
	
	/* private static final long serialVersionUID = 1L; */
// create variables
	String name;
	int balance;
	

    @Id // this annotation is to create primary value
	Integer accno;

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
