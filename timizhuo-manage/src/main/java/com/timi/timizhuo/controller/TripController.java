package com.timi.timizhuo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timi.timizhuo.common.ResponseData;
import com.timi.timizhuo.dao.entity.Images;
import com.timi.timizhuo.dao.entity.Trip;
import com.timi.timizhuo.service.TripService;

@Controller
@RequestMapping(value = "/trip")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@ResponseBody
    @RequestMapping(value = "/add", method=RequestMethod.POST)
	public ResponseData addTrip(HttpServletRequest request, Trip trip) {
		ResponseData responseData = new ResponseData();
		try {
			tripService.add(trip);
			responseData.setSuccess();
		} catch (Exception e) {
			responseData.setFial();
			responseData.setMessage("系统异常");
		}
		return responseData;
	}
	
	@ResponseBody
    @RequestMapping(value = "/find2row", method=RequestMethod.POST)
	public ResponseData find2row(HttpServletRequest request) {
		ResponseData responseData = new ResponseData();
		try {
			List<Trip> tripList = tripService.find2row();
			responseData.setData(tripList);
			responseData.setSuccess();
		} catch (Exception e) {
			responseData.setFial();
			responseData.setMessage("系统异常");
		}
		
		return responseData;
	}
	
	@ResponseBody
    @RequestMapping(value = "/findAll", method=RequestMethod.POST)
	public ResponseData findAll(HttpServletRequest request) {
		ResponseData responseData = new ResponseData();
		try {
			List<Trip> tripList = tripService.findAll();
			responseData.setData(tripList);	
			responseData.setSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setFial();
			responseData.setMessage("系统异常");
		}
		
		return responseData;
	}
}
