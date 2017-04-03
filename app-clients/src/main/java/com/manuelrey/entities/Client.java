package com.manuelrey.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Client implements Serializable {
	@Id @GeneratedValue
	private Long id;
	@NotNull
	@Size(min=4, max=15)
	private String first_name;
	@NotNull
	private String last_name;
	@NotNull
	private String email;
	private int telephone;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String first_name, String last_name, String email, int telephone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.telephone = telephone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	
}
