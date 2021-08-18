package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.LoginDAO;
import com.spring.mvc.model.LoginModel;
import com.spring.mvc.model.beans.UserBean;
import com.spring.mvc.service.LoginService;


/**
 * 컨트롤러, 서비스, 레파지토리로 login.java를 분리 service: DB에서 데이터를 가져올때, 중간에서 연산하거나 정리하는 역할
 * controller: model만 남아야 한다. view에서 넘어온 모델을 넘겨준다.
 * 
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private LoginDAO loginDAO;

	// "/login" URL이 실행되면 아래 메소드 실행, "/login"은 첫페이지이다.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginIndex(HttpServletRequest request) {// loginModel를 매개변수로 가져온다, loginService에서 가져온다
		ModelAndView mav;
		HttpSession session = request.getSession();
		UserBean loginUserBean = (UserBean) session.getAttribute("userBean");
		if (loginUserBean != null) {
			mav = new ModelAndView("/index");
		} else {
			mav = new ModelAndView("/login/login");
			LoginModel loginModel = loginService.getLoginModel();
			/*
			 * ModelAndView mav = new ModelAndView("/login/login"); -> jsp의 경로,
			 * views폴더/login폴더/login.jsp
			 * 
			 * LoginModel loginmodel = loginService.getLoginModel();
			 * mav.addObject("loginmodel", loginmodel); -> setAttribute의 기능
			 * mav.setViewName("/login/login");
			 */

		}
		return mav;
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck(LoginModel loginmodel, HttpServletRequest request) {
		/*
		 * view는 그대로 model만 달라진다.
		 * 성공했을때의 mav, 실패했을때의 mav를 따로 만듦
		 * 입력된 value값들을 들고온다(loginmodel을 활용해서 통째로 가져온다.)
		 * 
		 */
		HttpSession session = request.getSession();
		
		int flag = loginDAO.loginCheck(loginmodel);//로그인모델객체로 데이터를 받아와서 체크
		if(flag == 1) {
			ModelAndView mavLoginSuccess = new ModelAndView("/index");
			UserBean userBean = loginDAO.getUserBean(loginmodel);
			session.setAttribute("loginUserBean", userBean);
			return mavLoginSuccess;
		}else {
			ModelAndView mavLoginFailure = new ModelAndView("/login/login");
			return mavLoginFailure;
			//session에 빈저장해주어야 한다.
			//실패하면 실패한것을 넘겨주어야 한다.
		}
	}
		
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) { 
		HttpSession session = request.getSession(); 
		session.invalidate();//session종료 new
		ModelAndView view = new ModelAndView("/index"); 
		return view; 
	}
		 
		 
		
	

}
