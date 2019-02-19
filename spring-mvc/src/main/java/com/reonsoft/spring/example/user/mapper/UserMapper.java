package com.reonsoft.spring.example.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.reonsoft.spring.example.vo.UserLedgerVO;

/**
 * @ 서비스명 : 회원 Mapper
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
public interface UserMapper {
	
	public List<UserLedgerVO> selectUserList(UserLedgerVO vo) throws Exception;
	
	public List<UserLedgerVO> insertUserLedaer(UserLedgerVO vo) throws Exception;
	
}
