package com.timi.timizhuo.dao.mapper;

import com.timi.timizhuo.dao.model.UserModel;

/**
 * 婷迷用户DAO
 * @author 曾佳
 *
 */
public interface UserDao {

	/**
	 * 插入婷迷用户记录
	 * @param userModel
	 */
	void insert(UserModel userModel);

	/**
	 * 根据用户名更新婷迷用户信息
	 * @param user
	 */
	void updateByUsername(UserModel userModel);

	/**
	 * 根据用户名和密码查询婷迷用户信息
	 * @param userModel 
	 * @return
	 */
	UserModel findUserByUsernameAndPassword(UserModel userModel);

	/**
	 * 根据用户名查询婷迷用户信息
	 * @param username 用户名
	 * @return
	 */
	UserModel findUserByUsername(String username);

	/**
	 * 根据用户名或昵称查找婷迷用户信息
	 * @param existUserModel
	 * @return
	 */
	UserModel findUserByUsernameOrNickname(UserModel existUserModel);

}
