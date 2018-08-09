package com.timi.timizhuo.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 卓依婷演出&活动实体类
 * @author 曾佳
 */
public class Show implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 演出ID
	 */
	private String showId;
	
	/**
	 * 演出主题
	 */
	private String showTitle;
	
	/**
	 * 演出时间
	 */
	private Date showTime;
	
	/**
	 * 演出地点
	 */
	private String showAddress;
	
	/**
	 * 演出详情信息
	 */
	private String showDetail;
	
	/**
	 * 演出宣传图片路径，多张英文逗号隔开
	 */
	private String showImgs;
	
	/**
	 * 演出宣传视频
	 */
	private String showVideo;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public String getShowAddress() {
		return showAddress;
	}

	public void setShowAddress(String showAddress) {
		this.showAddress = showAddress;
	}

	public String getShowDetail() {
		return showDetail;
	}

	public void setShowDetail(String showDetail) {
		this.showDetail = showDetail;
	}

	public String getShowImgs() {
		return showImgs;
	}

	public void setShowImgs(String showImgs) {
		this.showImgs = showImgs;
	}

	public String getShowVideo() {
		return showVideo;
	}

	public void setShowVideo(String showVideo) {
		this.showVideo = showVideo;
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
