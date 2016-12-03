package com.tang.dao;

import com.tang.model.Admin;

/**
 * 用户Dao
 * @author TangXW
 *
 */
public interface AdminDao {
	// 登录
	boolean login(Admin admin);
}
