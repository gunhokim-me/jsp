package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilTest {

	@Test
	public void getFileNameTest() {
		/***Given***/
		String con =  "form-data; name=\"file\"; filename=\"brown.jpg\"";
		FileUtil fu = new FileUtil();
		/***When***/
		String res = fu.getFileName(con);
		/***Then***/
		assertEquals("brown.jpg", res);
	}
	@Test
	public void getFileNameFileTest() {
		/***Given***/
		String con =  "form-data; name=\"file\"";
		FileUtil fu = new FileUtil();
		/***When***/
		String res = fu.getFileName(con);
		/***Then***/
		assertEquals("", res);
	}
	
	@Test
	public void getFileExtenstionTest() {
		/***Given***/
		String filename =  "brown.png";
		FileUtil fu = new FileUtil();
		/***When***/
		String extension = fu.getFileExtension(filename);
		/***Then***/
		assertEquals(".png", extension);

	}
	
	@Test
	public void getFileExtenstionTest1() {
		/***Given***/
		String filename =  "line.brown.png";
		FileUtil fu = new FileUtil();
		/***When***/
		String extension = fu.getFileExtension(filename);
		/***Then***/
		assertEquals(".png", extension);
		
	}
	
	@Test
	public void getFileExtenstionTest2() {
		/***Given***/
		String filename =  "brown";
		FileUtil fu = new FileUtil();
		/***When***/
		String extension = fu.getFileExtension(filename);
		/***Then***/
		assertEquals("", extension);
		
	}

}
