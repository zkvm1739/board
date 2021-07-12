package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	/* 게시판 목록 */
	@Override
	public List<BoardVO> list() throws Exception {
		System.out.println("============listdao============");
		System.out.println("============DB============");
		return sql.selectList(namespace + ".list");
	}
	
	/* 게시판 작성 */
	@Override
	public void write(BoardVO vo) throws Exception {
		System.out.println("============writedao============");
		System.out.println("============DB============");
		sql.insert(namespace + ".write", vo);
		
	}

	/* 게시판 조회 */
	@Override
	public BoardVO view(int bno) throws Exception {
		System.out.println("============viewdao============");
		System.out.println("============DB============");
		System.out.println("sql : " +sql);
		sql.update(namespace + ".update",bno);
		System.out.println("sql : " + sql);
		return sql.selectOne(namespace + ".view", bno);
	}

	/* 게시글 수정 */
	@Override
	public void modify(BoardVO vo) throws Exception {
		System.out.println("============modifydao============");
		System.out.println("============DB============");
		sql.update(namespace + ".modify", vo);	
	}

	/* 게시글 삭제 */
	@Override
	public void delete(int bno) throws Exception {
		System.out.println("============deletedao============");
		System.out.println("============DB============");
		sql.delete(namespace + ".delete",bno);
	}
	
	/* 총 게시물 수 */
	@Override
	public int count() throws Exception {
		System.out.println("============countdao============");
		System.out.println("============DB============");
		return sql.selectOne(namespace + ".count");
	}

	/* 게시물 목록 + 페이징 */
	@Override
	public List listPage(int displayPost, int postNum) throws Exception {
		System.out.println("============listpagedao============");
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		System.out.println("data : " + data);
		data.put("postNum", postNum);
		System.out.println("data : " + data);
		System.out.println("============DB============");
		return sql.selectList(namespace + ".listPage",data);
	}

	/* 게시물 목록 + 페이징+ 검색 */
	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
			
		System.out.println("============listpagesearchDao============");
			
			HashMap<String, Object> data = new HashMap<String, Object>();
				
			  data.put("displayPost", displayPost);
			  data.put("postNum", postNum);
			  
			  System.out.println("data : " + data);
			  data.put("searchType", searchType);
			  data.put("keyword", keyword);
		  
			  System.out.println("data : " + data);
			  
			  System.out.println("============DB============");
			  
		  return sql.selectList(namespace + ".listPageSearch", data);
	}

	// 게시물 총 갯수 + 검색 적용
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 System.out.println("============searchCountDao============");
		 HashMap data = new HashMap();
		 
		 data.put("searchType", searchType);
		 data.put("keyword", keyword);
		 System.out.println("data : " + data);
	 System.out.println("============DB============");
	 return sql.selectOne(namespace + ".searchCount", data); 
	}
}
