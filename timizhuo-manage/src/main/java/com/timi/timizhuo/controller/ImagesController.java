package com.timi.timizhuo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timi.timizhuo.dao.entity.Images;
import com.timi.timizhuo.service.ImagesService;

@Controller
@RequestMapping(value = "/images")
public class ImagesController {
	
	@Autowired
	private ImagesService imagesService;

	@ResponseBody
    @RequestMapping(value = "/findAll", method=RequestMethod.POST)
	public List<Images> getLoginUser(HttpServletRequest request) {
		List<Images> list = imagesService.findAll();
		return list;
	}
}
