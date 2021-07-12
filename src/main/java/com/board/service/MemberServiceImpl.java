package com.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.MemberDAO;
import com.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO dao;
	
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		System.out.println("============registerService시작============");
		System.out.println("vo : " + vo);
		System.out.println("============Dao로 정보전달============");
		dao.register(vo);
		System.out.println("dao : " + dao);
		System.out.println("============registerservice끝============");
	}
	//로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		System.out.println("============loginservice============");
		return dao.login(vo);
	}
	//로그인 실패
	@Override
	public MemberVO faillogin(MemberVO vo) throws Exception {
		System.out.println("============failloginservice============");
		return dao.faillogin(vo);
	}

}
