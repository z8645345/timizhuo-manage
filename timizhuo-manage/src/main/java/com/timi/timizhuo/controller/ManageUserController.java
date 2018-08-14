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
import com.timi.timizhuo.dto.ManageUserDto;
import com.timi.timizhuo.dto.UserDto;
import com.timi.timizhuo.service.ManageUserService;

@Controller
@RequestMapping(value = "/manage/user")
public class ManageUserController {
	
	private static Logger logger = LoggerFactory.getLogger(ManageUserController.class);

	@Autowired
	private ManageUserService manageUserService;
	
	
	/**
	 * 婷迷用户登录
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value = "/login", method=RequestMethod.POST)
	public ResponseData login(HttpServletRequest request, ManageUserDto manageUserDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (manageUserDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(manageUserDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(manageUserDto.getPassword())) {
				responseData.setFial();
				responseData.setMessage(Constant.PASSWORD_NOT_NULL);
				return responseData;
			}
			ServiceResponseData<ManageUserDto> serviceResponseData = manageUserService.login(manageUserDto);
			if (serviceResponseData.isSuccess()) { // 登录成功
				request.getSession().setAttribute("LOGIN_USER", serviceResponseData.getData());
				responseData.setSuccess();
				responseData.setMessage(Constant.LOGIN_SUCCESS);
			} else {
				responseData.setFial();
				responseData.setMessage(serviceResponseData.getMessage());
			}
			
		} catch (Exception e) {
			logger.error("m:login 管理用户登录失败", e);
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
	public ResponseData logout(HttpServletRequest request, ManageUserDto manageUserDto) {
		ResponseData responseData = new ResponseData();
		try {
			if (manageUserDto == null) {
				responseData.setFial();
				responseData.setMessage(Constant.PARAMS_NOT_NULL);
				return responseData;
			}
			if (Strings.isNullOrEmpty(manageUserDto.getUsername())) {
				responseData.setFial();
				responseData.setMessage(Constant.USERNAME_NOT_NULL);
				return responseData;
			}
			request.getSession().removeAttribute("LOGIN_USER");
			responseData.setSuccess();
			responseData.setMessage(Constant.LOGOUT_SUCCESS);
		} catch (Exception e) {
			logger.error("m:logout 管理用户登出失败", e);
			responseData.setFial();
			responseData.setMessage(Constant.SYSTEM_ERROR);
		}
		return responseData;
	}
}
