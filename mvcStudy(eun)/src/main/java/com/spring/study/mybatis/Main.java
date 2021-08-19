package com.spring.study.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.study.model.study.Student;

public class Main {

	public static void main(String[] args) throws IOException {
		selectStudent();//메소드 실행
		
	}
	
	public static void selectStudent() throws IOException{
		/*
		 * IOException: 이 파일이 없을때 예외처리를 담당한다.
		 * 아래 3줄은 마이바티스를 불러오는 과정이고 마이바티스를 사용하기 위한 필수적인 3줄이라고 생각하면 편하다., 마이바티스의 상위가 아이바티스이다.
		 * 
		 * */
		Reader reader = Resources.getResourceAsReader("com/spring/mvc/mybatis/mybatis-config.xml");//" "주소에있는 xml의 리소스를 읽어서 reader객체에 집어넣는다. 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//xml파일 불러와서 빌드 한다.
		SqlSession session = sqlSessionFactory.openSession();//session오픈
		
		List<Student> list = session.selectList("Student.getStudentList");
		//mapper.xml에서 지정해준 위치를 가져온다. namespace.id의 형식으로 가져온다
		
		for (Student s : list) {
			System.out.println(s);
		}
		
		//getStudentSeq
		List<Integer> seqList = session.selectList("Student.getStudentSeq");
		for (Student i : list) {
			System.out.println(i);
		}
		
		//int
		String name = session.selectOne("Student.getStudentNameOne", 2);//, 뒤 값은 매개변수값(전달할 데이터의 값) & seq 2번재에 있는 이름을 가져온다.
		System.out.println("학생이름: " + name);
	}

}
