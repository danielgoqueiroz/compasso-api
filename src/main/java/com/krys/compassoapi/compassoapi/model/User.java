package com.krys.compassoapi.compassoapi.model;

public class User {

	private long id;
	private String name;
	private String password;
	private String cpf;
	private String email;

	
	
	public User() {
		super();
	}

	public User(String name, String password, String cpf, String email) {
		super();
		this.name = name;
		this.password = password;
		this.cpf = cpf;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
