package kr.or.ddit.emp.model;

public class EmployVo {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;

	//대다수의 framework는 기본 생성자를 필요로 한다
	public EmployVo() {}

	//getter, setter, toString
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

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
	
}
