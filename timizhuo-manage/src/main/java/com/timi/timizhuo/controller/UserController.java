package com.timi.timizhuo.controller;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timi.timizhuo.common.Constant;
import com.timi.timizhuo.common.ResponseData;
import com.timi.timizhuo.common.ServiceResponseData;
import com.timi.timizhuo.dao.entity.User;
import com.timi.timizhuo.dto.UserDto;
import com.timi.timizhuo.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	/**
	 * 婷迷用户注册
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/register", method=RequestMethod.POST)
	public ResponseData register(UserDto userDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (userDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getPassword())) {
				responseData.setFial();
				responseData.setMessage(Constant.PASSWORD_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getNickname())) {
				responseData.setFial();
				responseData.setMessage(Constant.NICKNAME_NOT_NULL);
				return responseData;
			}
			ServiceResponseData<User> serviceResponseData = userService.regist(userDto);
			if (serviceResponseData.isSuccess()) {
				responseData.setSuccess();
			} else {
				responseData.setFial();
				responseData.setMessage(serviceResponseData.getMessage());
			}
			
		} catch (Exception e) {
			logger.error("m:register 婷迷用户注册失败", e);
			responseData.setFial();
			responseData.setMessage(Constant.SYSTEM_ERROR);
		}
		return responseData;
	}
	
	/**
	 * 婷迷用户修改资料
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/updateUser", method=RequestMethod.POST)
	public ResponseData updateUser(UserDto userDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (userDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			ServiceResponseData<User> serviceResponseData = userService.updateUser(userDto);
			if (serviceResponseData.isSuccess()) {
				responseData.setSuccess();
				responseData.setData(serviceResponseData.getData());
			} else {
				responseData.setFial();
				responseData.setMessage(serviceResponseData.getMessage());
			}
			
		} catch (Exception e) {
			logger.error("m:updateUser 修改婷迷用户信息失败", e);
			responseData.setFial();
			responseData.setMessage(Constant.SYSTEM_ERROR);
		}
		return responseData;
	}
	
	/**
	 * 婷迷用户登录
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/login", method=RequestMethod.POST)
	public ResponseData login(HttpServletRequest request, UserDto userDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (userDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getPassword())) {
				responseData.setFial();
				responseData.setMessage(Constant.PASSWORD_NOT_NULL);
				return responseData;
			}
			ServiceResponseData<User> serviceResponseData = userService.login(userDto);
			if (serviceResponseData.isSuccess()) { // 登录成功
				request.getSession().setAttribute(serviceResponseData.getData().getUsername(), serviceResponseData.getData());
				responseData.setSuccess();
				responseData.setMessage(Constant.LOGIN_SUCCESS);
			} else {
				responseData.setFial();
				responseData.setMessage(serviceResponseData.getMessage());
			}
			
		} catch (Exception e) {
			logger.error("m:login 婷迷用户登录失败", e);
			responseData.setFial();
			responseData.setMessage(Constant.SYSTEM_ERROR);
		}
		return responseData;
	}
	
	/**
	 * 婷迷用户登出
	 */
	@ResponseBody
    @RequestMapping(value = "/logout", method=RequestMethod.POST)
	public ResponseData logout(HttpServletRequest request, UserDto userDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (userDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(userDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			request.getSession().removeAttribute(userDto.getUsername());
			responseData.setSuccess();
			responseData.setMessage(Constant.LOGOUT_SUCCESS);
		} catch (Exception e) {
			logger.error("m:logout 婷迷用户登出失败", e);
			responseData.setFial();
			responseData.setMessage(Constant.SYSTEM_ERROR);
		}
		return responseData;
	}
}
