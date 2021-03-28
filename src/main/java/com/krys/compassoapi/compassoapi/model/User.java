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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (other.getName().contentEquals(name)) {
			return true;
		}
		if (other.getEmail().contentEquals(email)) {
			return true;
		}
		if (other.getCpf().contentEquals(cpf)) {
			return true;
		}
		if (other.getId() == id ) {
			return true;
		}
		
		return true;
	}

}
