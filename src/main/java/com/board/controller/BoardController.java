package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.domain.Page;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	/* 게시판 목록 */
	@RequestMapping(value = "/list" , method=RequestMethod.GET)
	public void getList(Model model) throws Exception {	
		
		List<BoardVO> list = null;
		System.out.println("list : " + list);
		list = service.list();
		System.out.println("list : " + list);
		model.addAttribute("list", list);
	}
	
	/* 게시물 목록 + 페이징 추가 */
	@RequestMapping(value="/listPage",method = RequestMethod.GET)
	public void getListPage(Model model,@RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.count());  

		List list = null; 
		list = service.listPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list);   
		/*
		 * model.addAttribute("pageNum", page.getPageNum());
		 * 
		 * model.addAttribute("startPageNum", page.getStartPageNum());
		 * model.addAttribute("endPageNum", page.getEndPageNum());
		 * 
		 * model.addAttribute("prev", page.getPrev()); model.addAttribute("next",
		 * page.getNext());
		 */
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		/*
		 * // 총 게시물 수 int count = service.count();
		 * 
		 * //한페이지에 출력할 게시물 수 int postNum = 10;
		 * 
		 * // 하단 페이징 번호 ([ 게시물 총 수 / 한 페이지에 출력할 수]의 올림) int pageNum =
		 * (int)Math.ceil((double)count/postNum);
		 * 
		 * //출력할 게시물 int displayPost = (num - 1) * postNum;
		 * 
		 * // 한번에 표시할 페이징 번호의 갯수 int pageNum_cnt = 10;
		 * 
		 * // 표시되는 페이지 번호 중 마지막 번호 int endPageNum =
		 * ((int)Math.ceil((double)num/(double)pageNum_cnt)*pageNum_cnt);
		 * 
		 * // 마지막 번호 재계산 int endPageNum_tmp = (int)(Math.ceil((double)count /
		 * (double)pageNum_cnt));
		 * 
		 * if(endPageNum > endPageNum_tmp) { endPageNum = endPageNum_tmp; }
		 * 
		 * // 표시되는 페이지 번호 중 첫번째 번호 int startPageNum = endPageNum - (pageNum_cnt - 1);
		 * 
		 * // 10개씩 게시물 목록 List<BoardVO> list=null; list = service.listPage(displayPost,
		 * postNum); model.addAttribute("list", list); model.addAttribute("pageNum",
		 * pageNum);
		 * 
		 * // 시작 및 끝 번호 model.addAttribute("startPageNum",startPageNum);
		 * model.addAttribute("endPageNum",endPageNum);
		 * 
		 * //이전 다음 boolean prev = startPageNum == 1 ? false : true; boolean next =
		 * endPageNum * pageNum_cnt >= count ? false : true;
		 * 
		 * model.addAttribute("prev",prev); model.addAttribute("next",next);
		 */
	}
	
	/* 게시물 목록 + 페이징 추가 + 검색*/
	@RequestMapping(value="/listPageSearch",method = RequestMethod.GET)
	public void getListPageSearch(Model model,@RequestParam("num") int num,
			@RequestParam(value="searchType",required=false, defaultValue = "title") String searchType, 
			@RequestParam(value="keyword",required=false, defaultValue = "") String keyword) throws Exception {
		
		System.out.println("============list시작============");
		System.out.println("페이지num : " + num);
		System.out.println("SearchType : " + searchType);
		System.out.println("Keyword : " + keyword);
		Page page = new Page();
		System.out.println("page : " + page);
		page.setNum(num);
		System.out.println("page.setNum : " + page);
		/* page.setCount(service.count()); */  
		page.setCount(service.searchCount(searchType, keyword));
		System.out.println("page.setCount : " + page);
		// 검색 타입과 검색어
		page.setSearchTypeKeyword(searchType, keyword);
		System.out.println("page.setsearchTypeKeyword : " + page);
		List<BoardVO> list = null;
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		model.addAttribute("list", list);   
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		System.out.println("============list끝============");
	}
	
	/* 게시물 작성 GET */
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public void getWrite() throws Exception {
		System.out.println("============writeGet시작============");
	}
	/* 게시물 작성 POST */
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		System.out.println("============writePost시작============");
		System.out.println("============Service로 전달============");
		service.write(vo);
		System.out.println("============writePost끝============");
		return "redirect:/board/listPageSearch?num=1";
	}
	
	/* 게시물 조회 */	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		System.out.println("============viewGet시작============");
		BoardVO vo = service.view(bno);
		System.out.println("============jsp로 전달============");
		model.addAttribute("view", vo);
		System.out.println("============viewGet끝============");
	}
	
	/* 게시글 수정 GET*/
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		System.out.println("============modifyGet시작============");
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
		System.out.println("============modifyGet끝============");
	}
	
	/* 게시글 수정 POST*/
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String postMoidfy(BoardVO vo) throws Exception{
		System.out.println("===============modifyPost시작==============");
		service.modify(vo);
		System.out.println("===============modifyPost끝==============");
		return "redirect:/board/modify?bno="+vo.getBno();
	}
	
	/* 게시글 삭제 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
		System.out.println("===============deleteGet시작==============");
		service.delete(bno);
		System.out.println("===============deleteGet끝==============");
		return "redirect:/board/listPageSearch?num=1";
	}
	
}
