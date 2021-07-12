package com.board.dao;

import java.util.List;

import com.board.domain.ClothVO;

public interface ClothDao {

	public List<ClothVO> sexclothname(String sex, String clothname) throws Exception;

}
