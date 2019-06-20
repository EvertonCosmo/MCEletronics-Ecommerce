package com.mceletronics.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users") 
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	private String email;
	
	private String phone;
	
	private String adress;
	
	private String cpf;
	
	private String nameComplete;
	
	private String sexo;
	
	public User() {}
	public User( String username,  String password,  String email,  String phone,
			 String adress,  String cpf,  String nameComplete,  String sexo) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.cpf = cpf;
		this.nameComplete = nameComplete;
		this.sexo = sexo;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNameComplete() {
		return nameComplete;
	}
	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
