package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {
	
	//전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.selectAllUser();
		
		/***Then***/
		assertEquals(16, userList.size());
	}
	
	//사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		String userid = "brown";
		UserDaoI userDao = new UserDao();
		
		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
		
	}
	
	//사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		PageVo vo = new PageVo(1,5);
		
		/***When***/
		List<UserVo> pagingUser = userDao.selectPagingUser(vo);
		
		/***Then***/
		assertNotNull(pagingUser);
		assertEquals(5, pagingUser.size());
		
	}
	
	@Test
	public void selectUserCnt() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		
		/***When***/
		int userCnt = userDao.selectAllUserCnt();
		
		/***Then***/
		assertEquals(16, userCnt);
		
	}
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo vo = new UserVo("ddit","대덕인재","dditpass",new Date(),"개발원 m","대전시 중구 중앙로 76","4층 대덕인재개발원","34940");
		UserDaoI userDao = new UserDao();
		
		/***When***/
		int cnt = userDao.modifyUser(vo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void countUserTest() {
		/***Given***/
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		String userid = "moon";
		UserDaoI userDao = new UserDao();
		
		/***When***/
		int cnt = userDao.countUser(userid);
		
		/***Then***/
		assertEquals(1, cnt);
	}

}
