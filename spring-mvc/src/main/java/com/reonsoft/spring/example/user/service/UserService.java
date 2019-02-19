package com.reonsoft.spring.example.user.service;

import java.util.List;

import com.reonsoft.spring.example.vo.UserLedgerVO;

/**
 * @ 서비스명 : 회원 Service
 * @ 파일명   : UserService.java
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
********************************************************************
수정일			수정자		수정내용
********************************************************************
2019-01-23		박해상		최초작성
********************************************************************
**/
public interface UserService {
	
	public List<UserLedgerVO> selectUserList(UserLedgerVO vo) throws Exception;
	
}
