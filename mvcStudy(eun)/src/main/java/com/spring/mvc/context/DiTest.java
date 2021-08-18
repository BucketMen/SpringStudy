package com.spring.mvc.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(com.spring.mvc.context.DiAppConfig.class);//이 파일이 xml대신 bean을 생성하므로 여기를 지정
		//== ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/mvc/context/DiBeans.xml"); //만약 bean을 xml파일에서 생성한다면 이 코드를 사용할것!
		DiConnectionEx di = (DiConnectionEx)context.getBean("diConnectionEx");
		System.out.println(di);
	}

}
