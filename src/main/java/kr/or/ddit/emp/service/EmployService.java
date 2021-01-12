package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.model.EmployVo;
import kr.or.ddit.emp.repository.EmployDao;
import kr.or.ddit.emp.repository.EmployDaoI;

public class EmployService implements EmployServiceI{
	EmployDaoI dao = new EmployDao();
	
	@Override
	public List<EmployVo> selectAllEmploy() {
		return dao.selectAllEmploy();
	}
	
}
