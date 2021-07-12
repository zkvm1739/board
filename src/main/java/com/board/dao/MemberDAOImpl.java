package com.board.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		System.out.println("============registerDao시작============");
		System.out.println("vo : " + vo);
		System.out.println("============DB로 정보insert============");
		sql.insert(namespace  + ".register",vo);
		System.out.println("sql : " + sql);
		System.out.println("============registerDao끝============");
	}
	//로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		System.out.println("============logindao============");
		return sql.selectOne(namespace + ".login",vo);
	}
	//로그인 실패
	@Override
	public MemberVO faillogin(MemberVO vo) throws Exception {
		System.out.println("============faillogindao============");
		return sql.selectOne(namespace + ".login",vo);
	}
	}

