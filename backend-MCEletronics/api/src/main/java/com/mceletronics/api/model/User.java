package com.mceletronics.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;


@Table(name = "users")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@Nullable
	
	private String email;
	
	@Nullable
	private String adress;
	
	@Nullable
	private String phone;
	
	@Nullable
	private String cpf;
	
	@Nullable
	private String nameComplete;
	
	@Nullable
	private String sexo;
	
	public User(){
		super();
	}
	public User(@NotNull String username, @NotNull String password,  String email,  String phone,
			 String adress,  String cpf,  String nameComplete,  String sexo) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.cpf = cpf;
		this.nameComplete = nameComplete;
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", adress="
				+ adress + ", phone=" + phone + ", cpf=" + cpf + ", nameComplete=" + nameComplete + ", sexo=" + sexo
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
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
