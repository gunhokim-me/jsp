package kr.or.ddit.emp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployVo {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
}
