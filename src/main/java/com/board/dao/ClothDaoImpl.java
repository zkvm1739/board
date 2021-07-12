package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.ClothVO;

@Repository
public class ClothDaoImpl implements ClothDao {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	@Override
	public List<ClothVO> sexclothname(String sex, String clothname) throws Exception {
		
		System.out.println("==============dao1================");
		System.out.println(sex);
		HashMap <String, Object> data = new HashMap<String, Object>();
		data.put("sex", sex);
		data.put("clothname", clothname);
		System.out.println(data);
		sql.selectList(namespace+ ".sex",data);
		System.out.println("==============dao2================");
		return sql.selectList(namespace+ ".sex",data);
		
	}

}
