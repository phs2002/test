package com.reonsoft.spring.example.vo;

import java.io.Serializable;

public class EMPVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * EMPNO
	 */
	private int empno = 0;
	
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
	private int deptno = 0;
	
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
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
	
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
