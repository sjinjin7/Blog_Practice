package com.vam.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.mapper.MemberMapper;
import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberLoginTests {

	@Autowired
	private MemberMapper mapper;
	
	/* 로그인 쿼리 테스트 */
	@Test
	public void memberLogin() throws Exception{
		
		MemberVO member = new MemberVO();
		
		member.setMemberId("test");
		member.setMemberPw("1234");
		
		mapper.memberLogin(member);
				
		
	}
	
	
}
