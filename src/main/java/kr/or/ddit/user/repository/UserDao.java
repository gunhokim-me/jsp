package kr.or.ddit.user.repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI {

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select : 리턴되는 값의 복수 유무를 판단
		           //1. 단건 : 일반객체를 반환(UserVo) selectOne()
		           //2. 복수건 : List<UserVo> selectList)()
		//insert, update, delete : insert, update, delete
		//메소드 이름과 실행할 sql id를 동일하게 맞춰주면 유지보수(다른 개발자의 가독성) 할 때 편함
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//사용한 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();
		return user;
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser",vo);
		sqlSession.close();
		return userList;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		sqlSession.close();
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.update("users.modifyUser",vo);
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int countUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.selectOne("users.countUser",userid);
		sqlSession.close();
		return cnt;
	}

	@Override
	public int registUser(UserVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.insert("users.registUser",vo);
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

}
