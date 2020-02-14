package sp4.sp4_test01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext  ctx = 
				new GenericXmlApplicationContext(
						"classpath:applicationContxt.xml");
		Greeter gt = ctx.getBean("gr", Greeter.class);
		String msg = gt.greet("이숭무");
		System.out.println(msg);
		System.out.println(String.format("%d %s 입니다.", 10, "이숭무"));
		ctx.close();
	}

}
