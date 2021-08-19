package com.spring.study.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author ITPS
 * 여기서 bean을 생성할 것이다
 *
 *	메소드이름이 빈의 이름을 하고 
 *	return이 빈의 역할을 한다
 *
 */

@ComponentScan("com.spring.mvc.context")
@Configuration //이 파일이 xml파일을 대체하는 파일이라는 지정
public class DiAppConfig {
	@Bean//빈 생성
	public DiConnectionEx diconnectionEx() {
		//메소드명이 인스턴스 명
		return new DiConnectionEx();
	}
	/*
	 * 	
	 * <bean id="diex" class="com.spring.mvc.context.DiEx1">
	 *		<property name="name" value="이은수"></property>
	 *		<property name="phone" value="010-9988-1916"></property>
	 * </bean> 
	 *
	 * 을 여기서 쓴게 위 같은 방식이다
	 */
	@Bean
	public DiConnectionEx diconnectionEx2() {
		return new DiConnectionEx();
	}//이런식으로 여러개의 빈을 간단하게 만들 수있다.
}
