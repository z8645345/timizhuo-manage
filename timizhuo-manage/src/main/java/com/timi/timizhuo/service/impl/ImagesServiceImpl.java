package com.timi.timizhuo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timi.timizhuo.dao.entity.Images;
import com.timi.timizhuo.dao.mapper.ImagesDao;
import com.timi.timizhuo.dao.model.ImagesModel;
import com.timi.timizhuo.service.ImagesService;
import com.timi.timizhuo.util.BeanConvertUtils;

@Service
public class ImagesServiceImpl implements ImagesService {

	@Autowired
	private ImagesDao imagesDao;
	
	@Override
	public List<Images> findAll() {
		List<ImagesModel> imagesModelList = imagesDao.findAll();
		List<Images> imagesList = BeanConvertUtils.convertList(imagesModelList, Images.class);
		return imagesList;
	}
}
