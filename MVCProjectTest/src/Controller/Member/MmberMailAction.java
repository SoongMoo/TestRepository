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
		String subject = "�ȳ��ϼ���.������ �����մϴ�.";
		String content = "�ȳ��ϼ��� ������ ȯ���մϴ�. "
	+ "�Ʒ� ��ũ�� �����ž߸� ������ �Ϸ�˴ϴ�.<br />"
	+ "<a href='http://192.168.4.154:8080/MVCProjectTest/memberOk.nhn?"
	+ "num=" + num + "&email=" + receiver1 + "'>Ŭ��</a>";
		String server = "imap.gmail.com";
		String port = "465";
		// ���������� �����ϱ� ���� ��ü
		Properties properties = new Properties();
		properties.put("mail.smtp.host", server);
		properties.put("mail.smtp.port", port);
		// ���� ����
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback","false");
		// mail.Session��ü�� �̿��Ͽ� ���������� ���̵� �׸��� ��й�ȣ�� ����
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
			// ���� ����
			Transport.send(message,message.getAllRecipients());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
