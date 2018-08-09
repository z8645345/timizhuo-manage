package com.timi.timizhuo.dao.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 行程id
	 */
	private String id;
	
	/**
	 * 活动时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date activityTime;
	
	/**
	 * 活动地点
	 */
	private String activityLocal;
	
	/**
	 * 活动主题
	 */
	private String activityTitle;
	
	/**
	 * 活动状态
	 * 0：未开始
	 * 1：进行中
	 * 2：已结束
	 */
	private String activityStatus;
	
	/**
	 * 活动图片地址
	 */
	private String activityImgUrls;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityLocal() {
		return activityLocal;
	}

	public void setActivityLocal(String activityLocal) {
		this.activityLocal = activityLocal;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getActivityImgUrls() {
		return activityImgUrls;
	}

	public void setActivityImgUrls(String activityImgUrls) {
		this.activityImgUrls = activityImgUrls;
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
