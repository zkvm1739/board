package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.ClothVO;

@Controller
public class practiceController {

	@RequestMapping(value = "/practice", method = RequestMethod.GET)
	public void GETpractice(Model model)
			throws Exception {
		System.out.println("============controller===============");
		
	}
}
