package com.reonsoft.spring.example.vo;

import java.io.Serializable;

import com.reonsoft.spring.comm.vo.BaseVO;

public class UserLedgerVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 회원일련번호 */
	private String userSeq;
	
	/** 회원아이디 */
	private String userId;
	
	/** 회원비밀번호 */
	private String userPw;
	
	/** 회원이름 */
	private String userName;
	
	/** 회원이메일 */
	private String userEmail;
	
	/** 회원휴대폰번호 */
	private String userPhoneNb;
	
	/** 회원우편번호 */
	private String userZipCode;
	
	/** 회원도로명주소 */
	private String userLoadAddr;
	
	/** 회원지번주소 */
	private String userZipAddr;
	
	/** 회원구분 */
	private String userType;
	
	/** 회원상태 */
	private String userStatus;
	
	/** 등록년월일시 */
	private String regDate;
	
	/** 최종수정년월일시 */
	private String lastModDate;
	
	/** 최종로그인년월일시 */
	private String lastLoginDate;
	
	/**
	 * 회원일련번호 SET
	 * 
	 * @param userSeq - 회원일련번호
	 */
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	
	/**
	 * 회원일련번호 GET
	 * 
	 * @return 회원일련번호
	 */
	public String getUserSeq() {
		return userSeq;
	}
	
	/**
	 * 회원아이디 SET
	 * 
	 * @param userId - 회원아이디
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 회원아이디 GET
	 * 
	 * @return 회원아이디
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 회원비밀번호 SET
	 * 
	 * @param userPw - 회원비밀번호
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	/**
	 * 회원비밀번호 GET
	 * 
	 * @return 회원비밀번호
	 */
	public String getUserPw() {
		return userPw;
	}
	
	/**
	 * 회원이름 SET
	 * 
	 * @param userName - 회원이름
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 회원이름 GET
	 * 
	 * @return 회원이름
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 회원이메일 SET
	 * 
	 * @param userEmail - 회원이메일
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * 회원이메일 GET
	 * 
	 * @return 회원이메일
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * 회원휴대폰번호 SET
	 * 
	 * @param userPhoneNb - 회원휴대폰번호
	 */
	public void setUserPhoneNb(String userPhoneNb) {
		this.userPhoneNb = userPhoneNb;
	}
	
	/**
	 * 회원휴대폰번호 GET
	 * 
	 * @return 회원휴대폰번호
	 */
	public String getUserPhoneNb() {
		return userPhoneNb;
	}
	
	/**
	 * 회원우편번호 SET
	 * 
	 * @param userZipCode - 회원우편번호
	 */
	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}
	
	/**
	 * 회원우편번호 GET
	 * 
	 * @return 회원우편번호
	 */
	public String getUserZipCode() {
		return userZipCode;
	}
	
	/**
	 * 회원도로명주소 SET
	 * 
	 * @param userLoadAddr - 회원도로명주소
	 */
	public void setUserLoadAddr(String userLoadAddr) {
		this.userLoadAddr = userLoadAddr;
	}
	
	/**
	 * 회원도로명주소 GET
	 * 
	 * @return 회원도로명주소
	 */
	public String getUserLoadAddr() {
		return userLoadAddr;
	}
	
	/**
	 * 회원지번주소 SET
	 * 
	 * @param userZipAddr - 회원지번주소
	 */
	public void setUserZipAddr(String userZipAddr) {
		this.userZipAddr = userZipAddr;
	}
	
	/**
	 * 회원지번주소 GET
	 * 
	 * @return 회원지번주소
	 */
	public String getUserZipAddr() {
		return userZipAddr;
	}
	
	/**
	 * 회원구분 SET
	 * 
	 * @param userType - 회원구분
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * 회원구분 GET
	 * 
	 * @return 회원구분
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * 회원상태 SET
	 * 
	 * @param userStatus - 회원상태
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	/**
	 * 회원상태 GET
	 * 
	 * @return 회원상태
	 */
	public String getUserStatus() {
		return userStatus;
	}
	
	/**
	 * 등록년월일시 SET
	 * 
	 * @param regDate - 등록년월일시
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	/**
	 * 등록년월일시 GET
	 * 
	 * @return 등록년월일시
	 */
	public String getRegDate() {
		return regDate;
	}
	
	/**
	 * 최종수정년월일시 SET
	 * 
	 * @param lastModDate - 최종수정년월일시
	 */
	public void setLastModDate(String lastModDate) {
		this.lastModDate = lastModDate;
	}
	
	/**
	 * 최종수정년월일시 GET
	 * 
	 * @return 최종수정년월일시
	 */
	public String getLastModDate() {
		return lastModDate;
	}
	
	/**
	 * 최종로그인년월일시 SET
	 * 
	 * @param lastLoginDate - 최종로그인년월일시
	 */
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	/**
	 * 최종로그인년월일시 GET
	 * 
	 * @return 최종로그인년월일시
	 */
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	
}
