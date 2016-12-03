package com.tang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户持久化类
 * @author TangXW
 *
 */
@Entity
@Table(name="admin")
public class Admin {
	@Id
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	public Admin(){
		
	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	
}
