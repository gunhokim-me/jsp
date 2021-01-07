package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {

	/**
	 * Method : getCookieValue
	 * 작성자 : PC-01
	 * 변경이력 : 2021.01.06
	 * @param cookieStr
	 * @param cookieName
	 * @return 쿠키값
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	//cookieStr : userid=brown; rememberme=Y; test=testcookie
	//cookieName : userid, rememberme
	//return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {
		String [] cookies = cookieStr.split("; ");
		String[] names = new String[cookies.length];
		
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].contains(cookieName)) {
				names  = cookies[i].split("=");
				return names[1];
			}
		}
		return "";
	}
}
