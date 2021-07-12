package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.ClothVO;
import com.board.service.ClothService;

@Controller
@RequestMapping("/cloth/*")
public class ClothController {
	
	@Inject
	ClothService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ClothController.class);

	@RequestMapping(value = "/cloth", method = RequestMethod.GET)
	public void GETCloth(ClothVO vo,Model model,
			@RequestParam(value="sex",required=false) String sex, 
			@RequestParam(value="clothtype",required=false) String clothname) throws Exception {
		System.out.println("============controller===============");
		System.out.println(sex);
		/* service.sex(sex); */
		
	}
	@RequestMapping(value = "/cloth", method = RequestMethod.POST)
	public void postCloth(Model model,
			@RequestParam(value="sex",required=false) String sex, 
			@RequestParam(value="clothtype",required=false) String clothname) throws Exception {
		System.out.println("============controller1===============");
		System.out.println(sex);
		System.out.println(clothname);
		
		List<ClothVO> list = null;
		
		service.sexclothname(sex, clothname);
		list = service.sexclothname(sex, clothname);
		model.addAttribute("sex", list);
		
		System.out.println(list);
		System.out.println("============controller2===============");
	}

}
