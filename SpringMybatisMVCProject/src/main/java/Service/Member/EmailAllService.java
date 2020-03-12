package Service.Member;

import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import Repository.Member.MemberRepository;

public class EmailAllService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MemberRepository memberRepository;
	public void sendAll() {
		List<String> recivers = memberRepository.selectMemberAll();
		String subject = "안녕하세요.";
		String content = "안녀하세요 !!! 입니다.";
		MimeMessage msg = mailSender.createMimeMessage();
		System.out.println(recivers.size());
		for(String reciver : recivers) {
			try {
				msg.setHeader("content-type", "text/html; charset=UTF-8");
				msg.setContent(content, "text/html; charset=UTF-8");
				msg.setSubject(subject);
				msg.setRecipient(MimeMessage.RecipientType.TO, 
						new InternetAddress(reciver));
				mailSender.send(msg);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
