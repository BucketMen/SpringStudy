package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * model  = model
	 * return = view
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)//이게 주소가 된다, handler Mapping에게로 간다. 이후 아래 메소드가 실행된다.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);//print와 동일한 기능 log를 남겨준다.
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);//dataFormat에 해당하는 데이터를 넣는다.
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );//model
		
		return "home";//view
	}
	@RequestMapping(value = "/border2", method = RequestMethod.GET)//value에 값이 url로 요청이 들어오면 아래로 매핑해 준다.
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//addAtrbutte = setAttribute와 비슷한 역할을 ㅎ나다고 생각하면 된다 ㅎㅎㅎ
		
		return "home2";//view
	}
	
}
