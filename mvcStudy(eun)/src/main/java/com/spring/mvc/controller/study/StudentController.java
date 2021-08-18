package com.spring.mvc.controller.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.study.StudentDAO;
import com.spring.mvc.model.study.Student;

/**
 * 
 * 안되면 프로젝트 - 프로퍼티 - / 설정
 * 웹xml - /설정
 * filter 해주기
 *
 */

@Controller
public class StudentController {
	//@Controller도 컴포넌트 이다.
	
	@Autowired
	StudentDAO studentDAO;//얘는 얘한테 바로 주입한것
	//studentDAO라는 객체에 주입된다, 주입하면 StudentDAO클래스가 생성되서 주입된다, 생성과 동시에 기본생성자가 실행된다 하지만, 세터나 다른 메소드, 생성자위에 오토와이어가 있으면 그게 실행된다
	
	@RequestMapping(value = "/student/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/student/index");
		mav.addObject("student", new Student());
		return mav;
	}
	
	@RequestMapping(value = "/student/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView();
		
		//DB Insert
		studentDAO.insert(student);
		
		mav.setViewName("/student/addStudent");
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping(value = "/student/listStudent", method = RequestMethod.GET)
	public ModelAndView listStudent() {
		List<Student> students = studentDAO.select();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/student/listStudent");
		mav.addObject("students", students);
		return mav;
	}
	

}





