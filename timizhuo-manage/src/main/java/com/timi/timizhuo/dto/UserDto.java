package com.timi.timizhuo.dto;

import java.util.Date;

/**
 * 婷迷用户实体传输类
 * @author zengjia
 */
public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private String userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * 头像
	 */
	private String pic;
	
	/**
	 * 爱婷宣言
	 */
	private String loveTimiDeclaration = "卓依婷 我爱你";
	
	/**
	 * 个人简介
	 */
	private String personalProfile;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getLoveTimiDeclaration() {
		return loveTimiDeclaration;
	}

	public void setLoveTimiDeclaration(String loveTimiDeclaration) {
		this.loveTimiDeclaration = loveTimiDeclaration;
	}

	public String getPersonalProfile() {
		return personalProfile;
	}

	public void setPersonalProfile(String personalProfile) {
		this.personalProfile = personalProfile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
