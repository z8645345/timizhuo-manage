package com.timi.timizhuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timi.timizhuo.dao.entity.Trip;
import com.timi.timizhuo.dao.mapper.TripDao;
import com.timi.timizhuo.dao.model.TripModel;
import com.timi.timizhuo.service.TripService;
import com.timi.timizhuo.util.BeanConvertUtils;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDao stripDao;

	@Override
	public void add(Trip trip) {
		TripModel tripModel = new TripModel();
		BeanConvertUtils.convert(trip, tripModel);
		stripDao.add(tripModel);
	}

	@Override
	public List<Trip> find2row() {
		List<TripModel> tripModelList = stripDao.find2row();
		if (tripModelList == null || tripModelList.isEmpty()) {
			tripModelList = stripDao.find2rowOld();
		}
		List<Trip> tripList = BeanConvertUtils.convertList(tripModelList, Trip.class);
		return tripList;
	}

	@Override
	public List<Trip> findAll() {
		List<TripModel> newtripModelList = stripDao.findNew();
		List<TripModel> oldtripModelList = stripDao.findOld();
		newtripModelList.addAll(oldtripModelList);
		List<Trip> tripList = BeanConvertUtils.convertList(newtripModelList, Trip.class);
		return tripList;
	}
}
