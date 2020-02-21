package Controller.Member;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailSendAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {

		String sender = request.getParameter("sender");
		String receiver = request.getParameter("reciver");
		String subject = request.getParameter("subject");
		System.out.println("MailSendAction : " + subject);
		String content = request.getParameter("content");
		System.out.println("MailSendAction : " + content);
		
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
			// 메일내용 저장하기 위한 객체
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
