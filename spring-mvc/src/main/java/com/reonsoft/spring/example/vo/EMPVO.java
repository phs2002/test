package com.reonsoft.spring.example.vo;

import java.io.Serializable;

import com.reonsoft.spring.comm.vo.BaseVO;

public class EMPVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * EMPNO
	 */
	private String empno = "";
	
	/**
	 * ENAME
	 */
	private String ename = "";
	
	/**
	 * JOB
	 */
	private String job = "";
	
	/**
	 * MGR
	 */
	private int mgr = 0;
	
	/**
	 * HIREDATE
	 */
	private String hiredate = "";
	
	/**
	 * SAL
	 */
	private double sal = 0;
	
	/**
	 * COMM
	 */
	private double comm = 0;
	
	/**
	 * DEPTNO
	 */
	private String deptno = "";
	
	
	public String getEmpno() {
		return empno;
	}
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getMgr() {
		return mgr;
	}
	
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public double getSal() {
		return sal;
	}
	
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public double getComm() {
		return comm;
	}
	
	public void setComm(double comm) {
		this.comm = comm;
	}
	
	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}
