package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.model.ModelEx;

@Controller// dispatcher가 데이터를 불러온다
public class ControllerEx {
	
	@RequestMapping(value = "string", method = RequestMethod.GET)//구버전
	public String controller(Model model) {
		model.addAttribute("model", new ModelEx("String model"));
		return "/controllerEx/controller1";
	}
	
	@RequestMapping(value = "modelAndView", method = RequestMethod.GET)//신버전, 이걸 쓰는것을 권장
	public ModelAndView controller2() {
		//model & view를 묶어서 return
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/controllerEx/controller2"); 				//view
		mav.addObject("model", new ModelEx("ModelAndView model"));	//model
		return mav;
	}
	
	@RequestMapping(value = "/controllerEx/void", method = RequestMethod.GET)
	//주소값이 view가 된다, 소규모 프로젝트, 경로 지정을 하지 않을 경우에 사용한다.
	public void controller3(Model model) {
		model.addAttribute("model", new ModelEx("void model"));
		//return이 없다 = view가 없다.
	}
	
	@RequestMapping(value = "/controllerEx/modelEx", method = RequestMethod.GET)
	public ModelEx controller4() {
		//이름은 클래스의 이름을 참고해서 만들어야 한다.
		return new ModelEx("Model Class model");
		//단일 model을 반환한다.
	}
}