package com.board.service;

import java.util.List;

import com.board.domain.ClothVO;

public interface ClothService {

	public List<ClothVO> sexclothname(String sex, String clothname) throws Exception;

	
}
