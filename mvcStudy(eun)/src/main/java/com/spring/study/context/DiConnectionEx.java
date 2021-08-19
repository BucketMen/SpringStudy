package com.spring.study.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("DiConnectionEx")
public class DiConnectionEx {

	@Autowired(required = false) // required = false, Qualifier()안에 값이 없으면 null처리를 시킨다
	@Qualifier("diex2")
	private DiContext diex;
	/*
	 * diex2에 있는값을 여기의 diex에 주입한다. 기본생성자위로 올라가면 기본생성자가 실행된다. == private DiContext
	 * diex = new Diex2(); 위 세줄은 이 한줄과 같다. 상위의 객체 이 파일의 소스는 건들지 않고서 교체를 하기 편하게 하기
	 * 위해서 이렇게 작성한다.
	 * 
	 */

	public DiConnectionEx() {
		System.out.println("기본 생성자");
	}

	public DiConnectionEx(DiContext diex) {
		super();
		System.out.println("필드 주입 생성자");
		this.diex = diex;
	}

	public DiContext getDiex() {
		return diex;
	}

	public void setDiex(DiContext diex) {
		/*
		 * @Autowired가 xml파일의 property의 기능을 한다.
		 * 
		 * @AutoWired는 생성이 아닌 주입을 위한 존재이다. property가 만들 객체를 autowired가 그 역할을 한다, 없으면 객체가
		 * null, nullPoint오류발생 DiContext diex 즉 객체와 같은 이름을 가진 객체만 injection해준다.
		 * 
		 * @Qualifier("diex1"), 그래서 이것을 활용해서 인젝션 할 객체를 지정해 줄 수 있다. 빈값이면 이름이 같은 아이를 가져온다.
		 */
		System.out.println("setter 주입");
		this.diex = diex;
	}

	@Override
	public String toString() {
		if (diex == null) {
			return "";
		} else {
			return diex.diConnection();
		}
	}
}
