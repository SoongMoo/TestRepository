package Controller.Member;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MmberMailAction {
	public void sendMail(String receiver1) {
		String num = UUID.randomUUID().toString().replaceAll("-", "");
		String sender = "webmaster@aa.com";
		String receiver = receiver1;
		String subject = "안녕하세요.가입을 축하합니다.";
		String content = "안녕하세요 가입을 환영합니다. "
	+ "아래 링크를 누르셔야만 가입이 완료됩니다.<br />"
	+ "<a href='http://192.168.4.154:8080/MVCProjectTest/memberOk.nhn?"
	+ "num=" + num + "&email=" + receiver1 + "'>클릭</a>";
		String server = "imap.gmail.com";
		String port = "465";
		// 서버정보를 저장하기 위한 객체
		Properties properties = new Properties();
		properties.put("mail.smtp.host", server);
		properties.put("mail.smtp.port", port);
		// 보안 설정
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback","false");
		// mail.Session객체를 이용하여 서버정보와 아이디 그리고 비밀번호를 저장
		Session s = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				  	@Override
				  	protected PasswordAuthentication getPasswordAuthentication() {
				  	 	  return new PasswordAuthentication("hiland00","");
				  	}
				});
		try {
			Message message = new MimeMessage(s);
			Address sender_address = new InternetAddress(sender);
			Address receiver_address = new InternetAddress(receiver);
			message.setHeader("content-type", "text/html; charset=UTF-8");
			message.setFrom(sender_address);
			message.setRecipient(Message.RecipientType.TO, 
					receiver_address);
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=UTF-8");
			message.setSentDate(new Date());
			// 메일 전송
			Transport.send(message,message.getAllRecipients());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
