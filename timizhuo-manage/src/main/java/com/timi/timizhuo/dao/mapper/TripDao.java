package com.timi.timizhuo.dao.mapper;

import java.util.List;

import com.timi.timizhuo.dao.model.TripModel;

public interface TripDao {

	public Integer add(TripModel tripModel);

	public List<TripModel> find2row();
	
	public List<TripModel> find2rowOld();

	public List<TripModel> findNew();

	public List<TripModel> findOld();
}
