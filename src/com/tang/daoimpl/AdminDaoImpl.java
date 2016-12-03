package com.tang.daoimpl;

import org.hibernate.Session;
import com.tang.dao.AdminDao;
import com.tang.model.Admin;
import com.tang.util.HibernateUtil;

/**
 * 用户实现类
 * @author TangXW
 *
 */
public class AdminDaoImpl implements AdminDao{

	public boolean login(Admin admin) {
		boolean flag = false;
		Session sess = HibernateUtil.currentSession();
		// Transaction tx = sess.beginTransaction();
		Admin db_admin = (Admin) sess.get(Admin.class, admin.getUsername());
		if(db_admin != null){
			flag = true;
			System.out.println("登录成功!");
		}else{
			System.out.println("登录失败!");
		}
		HibernateUtil.closeSession();
		return flag;
	}

}
