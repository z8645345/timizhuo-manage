package com.timi.timizhuo.service;

import com.timi.timizhuo.common.ServiceResponseData;
import com.timi.timizhuo.dao.entity.User;
import com.timi.timizhuo.dto.UserDto;

/**
 * 婷迷用户业务接口类
 * @author zengjia
 */
public interface UserService {

	/**
	 * 婷迷用户注册
	 * @param user
	 * @return 
	 */
	public ServiceResponseData<User> regist(UserDto user) throws Exception;

	/**
	 * 婷迷用户修改资料
	 * @param user
	 * @return 
	 */
	public ServiceResponseData<User> updateUser(UserDto user) throws Exception;

	/**
	 * 婷迷用户登录
	 * @param user
	 * @return
	 */
	public ServiceResponseData<User> login(UserDto user) throws Exception;
}
