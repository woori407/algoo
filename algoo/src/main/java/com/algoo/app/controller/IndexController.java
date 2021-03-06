package com.algoo.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algoo.app.controller.IndexController;

@Controller
public class IndexController {
	private static final Logger logger
	=LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/index.ag")
	public String index(){
		logger.info("index 페이지 보여주기");
		
		return "index";
	}
}