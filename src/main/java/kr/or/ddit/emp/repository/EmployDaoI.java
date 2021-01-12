package kr.or.ddit.emp.repository;

import java.util.List;

import kr.or.ddit.emp.model.EmployVo;

public interface EmployDaoI {
	List<EmployVo> selectAllEmploy();
}
