package kr.or.ddit.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.emp.model.EmployVo;

public class EmployDao implements EmployDaoI{

	@Override
	public List<EmployVo> selectAllEmploy() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<EmployVo> list = sqlSession.selectList("employ.selectAllEmploy");
		sqlSession.close();
		return list;
	}

}
