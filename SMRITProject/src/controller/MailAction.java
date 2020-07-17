package controller;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.DTO.MemberDTO;

public class MailAction {
	public void sendMail(MemberDTO dto) {
		String num = UUID.randomUUID().toString().replace("-", "");
		String sender = "webmaster@soldesk.com";
		String receiver = dto.getUserEmail();
		String subject = dto.getUserName() +  "님 안녕하세요.가입을 축하합니다.";
		String content = dto.getUserName() +  "님 안녕하세요.가입을 축하합니다.<br />"
				+ "아래 링크를 누르셔야만 가입이 완료됩니다. <br />"
				+ "<a href='http://172.16.3.100:8080/SMRITProject"
				+ "/mem/memberJoinOk.mem?email="+dto.getUserEmail() 
				+ "&joinOk="+ num +"'>가입 확인 </a>";
		
		String server = "imap.gmail.com";
		String port = "465";
		// smtp설정 시작
		Properties properties = new Properties();
		properties.put("mail.smtp.host", server);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback",false);
		// smtp설정 끝
		Session s = Session.getDefaultInstance(properties, 
				new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("", "");
			}
		});
		//핸드폰 문자
		SmsSend ss = new SmsSend();
		String textMassage = null;
		// 메일링
		Message message = new MimeMessage(s);
		try {
			Address sender_address = new InternetAddress(sender);
			Address receiver_address = new InternetAddress(receiver);
			message.setHeader("content-type", "text/html; charset=UTF-8");
			message.setFrom(sender_address);
			message.setRecipient(Message.RecipientType.TO, receiver_address);
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=UTF-8");
			message.setSentDate(new Date());	
			Transport.send(message, message.getAllRecipients());
			
			textMassage = dto.getUserName() + "님 가입을 환영합니다. "
					+ "이메일로 접속하여 가입확인을 하여주시고 만약 본인 아닌 경우에는 "
					+ "1234-1234로 문의 주세요.";
			ss.smsSend(dto.getUserPh1(), textMassage);
		} catch (Exception e) {
			textMassage = dto.getUserName() + "님 가입을 환영합니다. "
					+ "이메일을 받지 못했을 경우에는 1234-1234로 문의 주세요.";
			ss.smsSend(dto.getUserPh1(), textMassage);
			e.printStackTrace();
		}
		
		
		
	}
}
