package com.timi.timizhuo.service.impl;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timi.timizhuo.common.Constant;
import com.timi.timizhuo.common.ServiceResponseData;
import com.timi.timizhuo.dao.entity.User;
import com.timi.timizhuo.dao.mapper.UserDao;
import com.timi.timizhuo.dao.model.UserModel;
import com.timi.timizhuo.dto.UserDto;
import com.timi.timizhuo.service.UserService;
import com.timi.timizhuo.util.BeanConvertUtils;
import com.timi.timizhuo.util.Md5Utils;

/**
 * 婷迷用户业务实现类
 * @author zengjia
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public ServiceResponseData<User> regist(UserDto userDto) throws Exception {
		ServiceResponseData<User> serviceResponseData = new ServiceResponseData<User>();
		
		// 判断用户名或者昵称是否被使用
		UserModel existUserModel = new UserModel();
		existUserModel.setUsername(userDto.getUsername());
		existUserModel.setNickname(userDto.getNickname());
		existUserModel = userDao.findUserByUsernameOrNickname(existUserModel);
		if (existUserModel != null) {
			if (existUserModel.getUsername().equals(userDto.getUsername())) {
				serviceResponseData.setMessage(Constant.USERNAME_EXIST);
			} else {
				serviceResponseData.setMessage(Constant.NICKNAME_EXIST);
			}
			serviceResponseData.setFail();
			return serviceResponseData;
		}
		
		// 插入数据
		UserModel userModel = new UserModel();
		BeanConvertUtils.convert(userDto, userModel);
		userModel.setPassword(Md5Utils.encoderByMd5(userModel.getPassword()));
		userDao.insert(userModel);
		serviceResponseData.setSuccess();
		return serviceResponseData;
	}
	
	@Override
	@Transactional
	public ServiceResponseData<User> updateUser(UserDto userDto) throws Exception {
		ServiceResponseData<User> serviceResponseData = new ServiceResponseData<User>();
		
		UserModel userModel = userDao.findUserByUsername(userDto.getUsername());
		if (userModel == null) {
			serviceResponseData.setFail();
			serviceResponseData.setMessage(Constant.USER_NOT_EXIST);
			return serviceResponseData;
		}
		
		if (!Strings.isNullOrEmpty(userDto.getPassword())) {
			userModel.setPassword(Md5Utils.encoderByMd5(userDto.getPassword()));
		}
		if (!Strings.isNullOrEmpty(userDto.getPic())) {
			userModel.setPic(userDto.getPic());
		}
		if (!Strings.isNullOrEmpty(userDto.getLoveTimiDeclaration())) {
			userModel.setLoveTimiDeclaration(userDto.getLoveTimiDeclaration());
		}
		if (!Strings.isNullOrEmpty(userDto.getLoveTimiDeclaration())) {
			userModel.setPersonalProfile(userDto.getLoveTimiDeclaration());
		}
		userDao.updateByUsername(userModel);
		serviceResponseData.setSuccess();
		return serviceResponseData;
	}

	@Override
	public ServiceResponseData<User> login(UserDto userDto) throws Exception {
		UserModel userModel = new UserModel();
		BeanConvertUtils.convert(userDto, userModel);
		userModel.setPassword(Md5Utils.encoderByMd5(userModel.getPassword()));
		UserModel loginUserModel = userDao.findUserByUsernameAndPassword(userModel);
		
		ServiceResponseData<User> serviceResponseData = new ServiceResponseData<User>();
		if (loginUserModel != null) {
			serviceResponseData.setSuccess();
			User loginUser = new User();
			BeanConvertUtils.convert(loginUserModel, loginUser);
			serviceResponseData.setData(loginUser);
		} else {
			serviceResponseData.setFail();
			serviceResponseData.setMessage(Constant.USERNAME_OR_PASSWORD_ERROR);
		}
		return serviceResponseData;
	}
}
