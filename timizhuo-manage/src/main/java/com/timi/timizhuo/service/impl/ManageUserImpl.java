package com.timi.timizhuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timi.timizhuo.common.Constant;
import com.timi.timizhuo.common.ServiceResponseData;
import com.timi.timizhuo.dao.mapper.ManageUserDao;
import com.timi.timizhuo.dao.model.ManageUserModel;
import com.timi.timizhuo.dto.ManageUserDto;
import com.timi.timizhuo.service.ManageUserService;
import com.timi.timizhuo.util.BeanConvertUtils;
import com.timi.timizhuo.util.Md5Utils;

/**
 * 管理用户业务实现类
 * @author zengjia
 */
@Service
public class ManageUserImpl implements ManageUserService {
	
	@Autowired
	private ManageUserDao manageUserDao; 

	@Override
	public ServiceResponseData<ManageUserDto> login(ManageUserDto manageUserDto) throws Exception {
		ServiceResponseData<ManageUserDto> serviceResponseData = new ServiceResponseData<ManageUserDto>();
		ManageUserModel manageUserModel = new ManageUserModel();
		manageUserModel.setUsername(manageUserDto.getUsername());
		manageUserModel.setPassword(Md5Utils.encoderByMd5(manageUserDto.getPassword()));
		ManageUserModel loginManageUserModel = manageUserDao.findUserByUsernameAndPassword(manageUserModel);
		if (loginManageUserModel == null) {
			serviceResponseData.setMessage(Constant.USERNAME_OR_PASSWORD_ERROR);
			serviceResponseData.setFail();
			return serviceResponseData;
		}
		ManageUserDto loginManageUserDto = new ManageUserDto();
		BeanConvertUtils.convert(loginManageUserModel, loginManageUserDto);
		serviceResponseData.setData(loginManageUserDto);
		return serviceResponseData;
	}
}
