package com.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.MemberVO;
import com.board.service.MemberService;

@Controller
@RequestMapping("/board/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
		@Inject
		MemberService service;
	
		// 회원가입 get
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public void getRegister(MemberVO vo) throws Exception {
			System.out.println("============회원가입GET시작============");
			System.out.println("vo : " + vo);
			System.out.println("============회원가입GET끝============");
		}

		// 회원가입 post
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String postRegister(MemberVO vo) throws Exception {
			System.out.println("============회원가입POST시작============");
			System.out.println("vo : " + vo);
			System.out.println("============memberservice로 정보전달============");
			service.register(vo);
			System.out.println("service : "+service);
			System.out.println("============회원가입POST끝============");
			System.out.println("============home으로 이동============");
			return "redirect:/";
		}
		
		/* 로그인  */
		@RequestMapping(value = "/login", method=RequestMethod.GET)
		public void getLogin() throws Exception{
		
		}
		// 로그인
		@RequestMapping(value="/login", method =RequestMethod.POST)
		public String postLogin(MemberVO vo, HttpServletRequest req) throws Exception {
			System.out.println("============로그인POST시작============");
			// service 호출단
			System.out.println("req : " + req);
			System.out.println("req=>session에 저장");
			HttpSession session = req.getSession();
			System.out.println("session : " + session);
			System.out.println("DB에 정보 login에 저장");
			MemberVO login = service.login(vo);
			System.out.println("login : " + login);
			System.out.println("============session 과 login 값 확인============");
			if (login == null) {
				System.out.println("============회원정보다름============");
				session.setAttribute("member", null);
				System.out.println("============session null============"+session);
				System.out.println("============로그인POST끝============");
				return "redirect:/board/faillogin";
			} else {
				System.out.println("============회원정보일치============");
				session.setAttribute("member", login);
				System.out.println("session : "+ session);
				System.out.println("============로그인POST끝============");
				System.out.println("============listPageSearch?num=1로============");
			return "redirect:/board/listPageSearch?num=1";
			}
			
		}
	
		// 로그인 실패 GET
		@RequestMapping(value="/faillogin",method=RequestMethod.GET)
		public void getfaillogin() throws Exception{
		}
		
		// 로그인 실패 POST
		@RequestMapping(value="/faillogin",method=RequestMethod.POST)
		public String postFailLogin(MemberVO vo) throws Exception {
			System.out.println("==========fail로그인POST시작==========");
			MemberVO faillogin = service.faillogin(vo);
			if (faillogin == null) {
				System.out.println("==========fail로그인POST끝1==========");
				return "board/faillogin";
			} else {
				System.out.println("==========fail로그인POST끝2==========");
			return "redirect:/board/listPageSearch?num=1";
			}
		}
}
