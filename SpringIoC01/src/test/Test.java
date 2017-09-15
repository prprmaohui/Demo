package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.EmpService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		System.out.println(context);
		EmpService empService =
				(EmpService) context.getBean("empService");
		System.out.println(empService.getEmpDao());
		System.out.println(empService.getDeptDao());
	}

}
