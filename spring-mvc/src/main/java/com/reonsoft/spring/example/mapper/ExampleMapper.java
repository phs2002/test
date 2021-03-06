package com.reonsoft.spring.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reonsoft.spring.example.vo.EMPVO;

/**
 * @ 서비스명 : 예제 Mapper
 * @ 파일명   : ExampleMapper.java
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
********************************************************************
수정일			수정자		수정내용
********************************************************************
2019-01-23		박해상		최초작성
********************************************************************
**/
@Mapper
public interface ExampleMapper {
	
	public List<EMPVO> selectEMPList(EMPVO bbsVO) throws Exception;
	
}
