package com.timi.timizhuo.service;

import java.util.List;

import com.timi.timizhuo.dao.entity.Trip;

public interface TripService {

	/**
	 * 添加行程信息
	 * @param trip
	 */
	public void add(Trip trip);

	/**
	 * 查询最新两条演出信息
	 * @return
	 */
	public List<Trip> find2row();

	/**
	 * 查询所有演出信息
	 * @return
	 */
	public List<Trip> findAll();
}
