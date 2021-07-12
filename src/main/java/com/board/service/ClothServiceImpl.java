package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.ClothDao;
import com.board.domain.ClothVO;

@Service
public class ClothServiceImpl implements ClothService {

	@Inject
	private ClothDao dao;
	
	@Override
	public List<ClothVO> sexclothname(String sex, String clothname) throws Exception {
		System.out.println("============service1===============");
		System.out.println(sex);
		dao.sexclothname(sex, clothname);
		System.out.println(dao);
		System.out.println("============service2===============");
	return dao.sexclothname(sex,clothname);
		
	}

}
