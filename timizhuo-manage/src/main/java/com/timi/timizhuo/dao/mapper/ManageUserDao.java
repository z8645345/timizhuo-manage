package com.timi.timizhuo.dao.mapper;

import com.timi.timizhuo.dao.model.ManageUserModel;

/**
 * 管理用户dao
 * @author 曾佳
 */
public interface ManageUserDao {

	/**
	 * 根据用户名密码查询管理用户信息
	 * @param manageUserModel
	 * @return
	 */
	public ManageUserModel findUserByUsernameAndPassword(ManageUserModel manageUserModel);
}
