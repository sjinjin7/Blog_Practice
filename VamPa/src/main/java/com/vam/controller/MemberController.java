package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	//회원가입 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void loginGET() {
		
		logger.info("회원가입 페이지 진입");
		
	}
	
	//로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void joinGET() {
		
		logger.info("로그인 페이지 진입");
		
	}	
	
	
	//회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception{
		
		logger.info("join 진입");
		
		String rawPw = "";					// 인코딩 전 비밀번호
		String encodePw = "";				// 인코딩 후 비밀번호
		
		rawPw = member.getMemberPw();
		encodePw = pwEncoder.encode(rawPw);
		member.setMemberPw(encodePw);
		
		/* 회원가입 쿼리 실행 */
		memberservice.memberJoin(member);
		
		logger.info("join Service 성공");
		
		return "redirect:/main";
		
		
		/* 기존 회원가입 코드
		logger.info("join 진입");
		
		// 회원가입 서비스 실행
		memberservice.memberJoin(member);
		
		logger.info("join Service 성공");
		
		return "redirect:/main";
		*/
	}	//joinPOST() 종료
	
	// 아이디 중복 검사
	@RequestMapping(value="/memberIdChk", method=RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception{
		
		logger.info("memberIdChkPOST() 진입");
		
		int result = memberservice.idCheck(memberId);
		
		logger.info("결과값 = " + result);
		
		if(result != 0) {
			
			return "fail";		// 중복 아이디가 존재
			
		} else {
			
			return "success";		// 중복 아이디 없음
			
		}
		
	}
	
	//이메일 인증
	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		
		/* 뷰로 부터 넘어온 데이터 확인 */
		logger.info("이메일인증 컨트롤러 전송 확인 ");
		logger.info("email : " + email);
		
		/* 인증번호 난수 만들기 */
		Random random = new Random();
		int checkNum = random.nextInt(4589362) + 49311;
		logger.info("인증번호 " + checkNum);
		
		/* 이메일 보내기 */
		String setFrom = "sjinjin6@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = 
				"홈페이지를 방문해주셔서 감사합니다." +
				"<br><br>" + 
				"인증 번호는 " + checkNum + "입니다." + 
				"<br>" + 
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String num = Integer.toString(checkNum);
		
		return num;
		
	}
	
	/* 로그인 */
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr)throws Exception{
	
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";
		
		MemberVO vo = memberservice.memberLogin(member);
		
		if(vo != null) {		// 아이디 존재 경우
			rawPw = member.getMemberPw();
			encodePw = vo.getMemberPw();
			
			if(true == pwEncoder.matches(rawPw, encodePw)) {
				
				vo.setMemberPw("");	// 비밀번호 비우기
				
				session.setAttribute("member", vo);
				
				return "redirect:/main";
				
			} else {			// 로그인 실패(비밀번호 일치하지 않을 경우)
				
				rttr.addFlashAttribute("result", 0);
				return "redirect:/member/login";	// 로그인 페이지로 반환
				
			}
			
		} else {				// 로그인 실패(아이디 존재하지 않을 경우)
			
			rttr.addFlashAttribute("result", 0);
			return "redirect:/member/login";	// 로그인 페이지로 반환
			
		}
		
		
		
	/*
		HttpSession session = request.getSession();
		MemberVO vo = memberservice.memberLogin(member);
		System.out.println("" + vo);
		
		if(vo == null) {		// 잘못된 아이디, 비밀번호 입력 혹은 입력란 공란일 경우
			
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/member/login";
			
			
		}
		
		session.setAttribute("member", vo);	// null이 아니라는 것은 로그인이 정상적으로 진행 됫다는 의미
		
		
		return "redirect:/main";
	*/	
	}
	
	
	/* 메인페이지용 로그아웃 */
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) throws Exception{
		
		logger.info("logout메서드 진입");
		
		HttpSession session = request.getSession();
		
		session.invalidate();		
		
		return "redirect:/main";
		
	}
	
	
	/* 비동기방식 로그아웃 메서드 */
	@RequestMapping(value="logout.do", method=RequestMethod.POST)
	@ResponseBody
	public void logoutPOST(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
	}
	
}
