package com.loan.global.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.loan.global.dto.AdDTO;
import com.loan.global.dto.QqDTO;

@Repository
public interface GlobalDao {
	public AdDTO getAdById(int id);
	public ArrayList<QqDTO> getQqByType(@Param("typeid") int typeid);
}
