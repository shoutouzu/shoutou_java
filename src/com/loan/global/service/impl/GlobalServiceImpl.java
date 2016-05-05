package com.loan.global.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.global.dao.GlobalDao;
import com.loan.global.dto.AdDTO;
import com.loan.global.dto.QqDTO;
import com.loan.global.service.IGlobalService;

@Service
public class GlobalServiceImpl implements IGlobalService {
	
	@Autowired
	private GlobalDao globalDao;
	@Override
	public AdDTO getAdById(int id) {
		AdDTO  ad = globalDao.getAdById(id) ;
		if(ad == null){
			return null;
		}
		return ad;
	}
	public ArrayList<QqDTO> getQqByType(@Param("typeid") int typeid){
		return globalDao.getQqByType(typeid);
	}
}
