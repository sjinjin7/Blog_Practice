package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookMapperTests {

	@Autowired
	private BookMapper mapper;
	
	@Test
	public void getAttachListTests() {
		
		int bookId = 49152;
		
		System.out.println("result : " + mapper.getAttachList(bookId));
		
		
	}
	
	
}
