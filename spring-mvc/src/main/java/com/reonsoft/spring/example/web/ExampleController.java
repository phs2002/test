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
	
	@RequestMapping(value = {"/example", "/emp/list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String empList(Model model, EMPVO vo) throws Exception {
		
		logger.info("call ExampleController empList");
		logger.info("EMPVO[" + vo.toString() + "]");
		
		model.addAttribute("empList", exampleService.selectEMPList(vo));
		
		return "example/empList_V";
	}
	
	@RequestMapping(value = "/emp/reg", method = {RequestMethod.GET, RequestMethod.POST})
	public String empReg(Model model, EMPVO vo) throws Exception {
		
		logger.info("call ExampleController empReg");
		logger.info("EMPVO[" + vo.toString() + "]");
		
		model.addAttribute("empList", exampleService.selectEMPList(vo));
		
		return "example/empReg_V";
	}
	
	@RequestMapping(value = "/emp/dtl", method = {RequestMethod.GET, RequestMethod.POST})
	public String empDtl(Model model, EMPVO vo) throws Exception {
		
		logger.info("call ExampleController example");
		logger.info("EMPVO[" + vo.toString() + "]");
		
		model.addAttribute("empList", exampleService.selectEMPList(vo));
		
		return "example/empDtl_V";
	}
	
}
