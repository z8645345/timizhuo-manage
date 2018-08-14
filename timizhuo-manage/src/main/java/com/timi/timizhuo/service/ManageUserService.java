package com.timi.timizhuo.service;

import com.timi.timizhuo.common.ServiceResponseData;
import com.timi.timizhuo.dto.ManageUserDto;

/**
 * 管理用户业务接口类
 * @author zengjia
 */
public interface ManageUserService {

	public ServiceResponseData<ManageUserDto> login(ManageUserDto manageUserDto) throws Exception;
}
