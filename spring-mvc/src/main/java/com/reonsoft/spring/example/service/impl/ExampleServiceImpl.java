package com.reonsoft.spring.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reonsoft.spring.example.mapper.ExampleMapper;
import com.reonsoft.spring.example.service.ExampleService;
import com.reonsoft.spring.example.vo.EMPVO;

/**
 * @ 서비스명 : 예제 Service Implements
 * @ 파일명   : ExampleServiceImpl.java
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
********************************************************************
수정일			수정자		수정내용
********************************************************************
2019-01-23		박해상		최초작성
********************************************************************
**/
@Service("ExampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);
	
	@Autowired
	private ExampleMapper exampleMapper;
	
	@Override
	public List<EMPVO> selectEMPList(EMPVO vo) throws Exception {
		
		List<EMPVO> list = new ArrayList<EMPVO>();
		
		try {
			
			logger.debug("vo {}", vo);
			
			list = exampleMapper.selectEMPList(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
