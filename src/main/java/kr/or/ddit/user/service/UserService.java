package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI{
	
	private UserDaoI userDao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = userDao.selectPagingUser(vo);
		int userCnt = userDao.selectAllUserCnt();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	@Override
	public int modifyUser(UserVo vo) {
		return userDao.modifyUser(vo);
	}

	@Override
	public int countUser(String userid) {
		return userDao.countUser(userid);
	}

	@Override
	public int registUser(UserVo vo) {
		return userDao.registUser(vo);
	}

	@Override
	public int deleteUser(String userid) {
		return userDao.deleteUser(userid);
	}
}
