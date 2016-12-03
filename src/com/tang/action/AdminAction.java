package com.tang.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tang.dao.AdminDao;
import com.tang.daoimpl.AdminDaoImpl;
import com.tang.model.Admin;

public class AdminAction extends ActionSupport{
	private AdminDao service = new AdminDaoImpl();
	private Admin admin;
	
	// 登录
	public String login(){
		if(service.login(admin)){
			return SUCCESS;
		}
		return ERROR;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
