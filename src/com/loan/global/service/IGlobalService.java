package com.loan.global.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.loan.global.dto.AdDTO;
import com.loan.global.dto.QqDTO;

public interface IGlobalService {
	public AdDTO getAdById(int id);
	public ArrayList<QqDTO> getQqByType(@Param("typeid") int typeid);
}
