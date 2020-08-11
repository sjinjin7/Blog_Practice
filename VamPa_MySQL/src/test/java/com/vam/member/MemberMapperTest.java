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
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;
	
	@Test
	public void memberJoin() throws Exception{
		MemberVO member = new MemberVO();
		member.setMemberId("test");
		member.setMemberPw("1234");
		member.setMemberName("test");
		member.setMemberMail("test");
		member.setMemberAddr1("123");
		member.setMemberAddr2("member");
		member.setMemberAddr3("member");
		member.setAdminCk(0);
		member.setPoint(100);
		member.setMoney(100);
		membermapper.memberJoin(member);
	}
	
	
}
