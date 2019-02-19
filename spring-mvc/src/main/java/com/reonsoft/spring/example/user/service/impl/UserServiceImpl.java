package com.reonsoft.spring.example.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reonsoft.spring.example.mapper.ExampleMapper;
import com.reonsoft.spring.example.service.ExampleService;
import com.reonsoft.spring.example.user.service.UserService;
import com.reonsoft.spring.example.vo.EMPVO;
import com.reonsoft.spring.example.vo.UserLedgerVO;

/**
 * @ 서비스명 : 회원 Service Implements
 * @ 파일명   : UserServiceImpl.java
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
********************************************************************
수정일			수정자		수정내용
********************************************************************
2019-01-23		박해상		최초작성
********************************************************************
**/
@Service("UserService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userMapper;
	
	@Override
	public List<UserLedgerVO> selectUserList(UserLedgerVO vo) throws Exception {
		
		List<UserLedgerVO> list = new ArrayList<UserLedgerVO>();
		
		try {
			
			logger.debug("vo {}", vo);
			
			list = userMapper.selectUserList(vo);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
