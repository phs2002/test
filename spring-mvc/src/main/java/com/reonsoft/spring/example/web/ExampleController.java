package com.reonsoft.spring.example.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reonsoft.spring.example.service.ExampleService;
import com.reonsoft.spring.example.vo.EMPVO;

@Controller
public class ExampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
	
	@Resource(name="ExampleService")
	private ExampleService exampleService;
	
	@RequestMapping(value = "/example", method = {RequestMethod.GET, RequestMethod.POST})
	public String example(Model model, EMPVO vo) throws Exception {
		
		logger.info("call ExampleController example");
		
		model.addAttribute("empList", exampleService.selectEMPList(vo));
		
		return "example/empList_V";
	}
	
}
