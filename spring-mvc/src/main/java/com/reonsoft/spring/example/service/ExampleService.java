package com.reonsoft.spring.example.service;

import java.util.List;

import com.reonsoft.spring.example.vo.EMPVO;

/**
 * @ 서비스명 : 예제 Service
 * @ 파일명   : ExampleService.java
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
********************************************************************
수정일			수정자		수정내용
********************************************************************
2019-01-23		박해상		최초작성
********************************************************************
**/
public interface ExampleService {
	
	public List<EMPVO> selectEMPList(EMPVO vo) throws Exception;
	
}
