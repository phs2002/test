package com.reonsoft.spring.main;

import java.sql.Connection;
import java.sql.DriverManager;
 
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
 
public class OracleConnectionTest {
	
	// 로깅을 위한 변수 선언
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	
	// 연결문자열 jdbc:oracle:thin:@호스트:포트:sid
	private static final String URL = "jdbc:oracle:thin:@192.168.0.200:1521:orcl";
	private static final String USER = "scott";//아이디
	private static final String PW = "tiger";//
	
	@Test //Junit이 테스트하는 메소드
	public void test() throws ClassNotFoundException {
		
		Class.forName(DRIVER); //jdbc 드라이버 로딩
		
		//괄호안에 리소스 자동 삭제 
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			logger.info("오라클에 연결되었습니다");
			
			System.out.println(ObjectUtils.isEmpty(null));
			// Spring 프레임워크에서 제공되는 empty Util은 공백에 대한 검증이 안되고 있음
			System.out.println(ObjectUtils.isEmpty(" "));
			System.out.println(com.reonsoft.spring.common.util.ObjectUtils.isEmpty(null));
			System.out.println(com.reonsoft.spring.common.util.ObjectUtils.isEmpty(" "));
			System.out.println(com.reonsoft.spring.common.util.ObjectUtils.isNotEmpty(null));
			System.out.println(com.reonsoft.spring.common.util.ObjectUtils.isNotEmpty(" "));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 
}
