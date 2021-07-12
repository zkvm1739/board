package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	/* 게시물 목록 */
	@Override
	public List<BoardVO> list() throws Exception {
		System.out.println("============listservice시작============");
		System.out.println("============dao로 전달============");
		return dao.list();
	}

	/* 게시물 작성 */
	@Override
	public void write(BoardVO vo) throws Exception {
		System.out.println("============writeservice============");
		System.out.println("============dao로 전달============");
		dao.write(vo);
	}

	/* 게시물 조회 */
	@Override
	public BoardVO view(int bno) throws Exception {
		
		System.out.println("============viewservice============");
		System.out.println("bno : " + bno);
		System.out.println("============dao로 전달============");
		return dao.view(bno);
	}

	/* 게시글 수정 */
	@Override
	public void modify(BoardVO vo) throws Exception {
		System.out.println("============modifyservice============");
		System.out.println("============dao로 전달============");
		dao.modify(vo);
	}
	
	/* 게시글 삭제 */
	@Override
	public void delete(int bno) throws Exception {
		System.out.println("============deleteservice=============");
		System.out.println("============dao로 전달============");
		dao.delete(bno);
	}

	/* 총 게시물 수 */
	@Override
	public int count() throws Exception {
		System.out.println("============countservice============");
		System.out.println("============dao로 전달============");
		return dao.count();
	}

	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		System.out.println("============listpageservice============");
		System.out.println("============dao로 전달============");
		return dao.listPage(displayPost, postNum);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
			System.out.println("============listpagesearchservice============");
			System.out.println("============dao로 전달============");
			 return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		System.out.println("============searchcountservice============");
		System.out.println("============dao로 전달============");
		return dao.searchCount(searchType, keyword);
	}
	}

