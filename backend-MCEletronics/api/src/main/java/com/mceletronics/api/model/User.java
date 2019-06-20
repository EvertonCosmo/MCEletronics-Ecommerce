package com.mceletronics.api.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

@Entity
@Table(name ="users")
public class User  {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List <Role> roles; 
	
	@NotNull
	private String username;
	
	
	@NotNull
	private String password;
	
	@Nullable
	private String email;
	
	@Nullable
	private String phone;
	
	@Nullable 
	private String adress;
	
	@Nullable
	private String cpf;
	
	@Nullable
	private String nameComplete;
	
	@Nullable
	private String sexo;
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
	
	public User(@NotNull String username, @NotNull String password, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User( @NotNull String username, @NotNull String password,  @Nullable String email, @Nullable String phone,
			@Nullable String adress,  @Nullable String cpf,  @Nullable String nameComplete,  @Nullable String sexo, List<Role> roles) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.cpf = cpf;
		this.nameComplete = nameComplete;
		this.sexo = sexo;
		this.roles = roles;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", roles=" + roles + ", username=" + username + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", adress=" + adress + ", cpf=" + cpf + ", nameComplete=" + nameComplete
				+ ", sexo=" + sexo + "]";
	}
}
