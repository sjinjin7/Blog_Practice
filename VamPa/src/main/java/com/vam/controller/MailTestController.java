package com.vam.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.io.FileSystemResource;
/*
@Controller
@RequestMapping("/mail")
public class MailTestController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public void sendMailTest() throws Exception{
		
		String subject = "test 메일";
		String content = "메일 테스트 내용" + "<img src=\"https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625\">";
		String from = "보내는이 아이디@도메인주소";
		String to = "받는이 아이디@도메인주소";
		
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
			
			mailHelper.setFrom(from);
			mailHelper.setTo(to);
			mailHelper.setSubject(subject);
			mailHelper.setText(content, true);
			
			FileSystemResource file = new FileSystemResource(new File("D:\\test.txt")); 
			mailHelper.addAttachment("업로드파일.형식", file);
			
			mailSender.send(mail);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public void sendMailTest2() throws Exception{

		String subject = "test 메일";
		String content = "메일 테스트 내용.";
		String from = "보내는이 아이디@도메인주소";
		String to = "받는이 아이디@도메인주소";
		
		
		final MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception{
				final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				
				mailHelper.setFrom(from);
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);

			}
			
		};
		
		try {	
			mailSender.send(preparator);
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
	}	
	
}
*/