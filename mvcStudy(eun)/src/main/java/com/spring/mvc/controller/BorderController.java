package com.spring.mvc.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.bytecode.analysis.MultiType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.BorderDAO;
import com.spring.mvc.model.BorderDtlModel;
import com.spring.mvc.model.BorderInsertModel;
import com.spring.mvc.model.BorderListModel;
import com.spring.mvc.service.border.BorderDtlService;
import com.spring.mvc.service.border.BorderInsertService;
import com.spring.mvc.service.border.BorderListSet;


@Controller
public class BorderController {
	
	@Autowired
	BorderListSet borderListSet;
	
	@Autowired
	BorderDtlService borderDtlService;
	
	//@Autowired
	//BorderInsertService borderInsertService;
	
	@Autowired
	BorderDAO borderDAO;
	
	@RequestMapping(value= "/border", method= RequestMethod.GET)
	public ModelAndView borderIndex(){
		//borderListModel은 파라메터값을 받아오는 것이다, page라는것으로 파라메터값을 받아온다.
		ModelAndView view = new ModelAndView("/border/border");
		BorderListModel model = new BorderListModel();
		model.setPage(1);//첫번째 페이지를 1로 지정해 주지 않으면 nullpointexception이 뜨니까 지정해준다.
		model.setBorderList(borderListSet.getBorderList(model.getPage()));//border.jsp를 받아오려면 여러가지를 받아와야 하므로 list로 모델을 지정하고 받아온다
		model.setTotalPage(borderListSet.getTotalPage());
		model.setPageStart(borderListSet.getPageStart(model.getPage()));
		model.setPageEnd(borderListSet.getPageEnd(model.getPage()));
		view.addObject("borderModel", model);
		return view;
	}
	
	@RequestMapping(value= "/borderp", method= RequestMethod.GET)
	public ModelAndView borderIndex2(@RequestParam("page")String page){
		// page라는것으로 파라메터값을 받아온다.
		ModelAndView view = new ModelAndView("/border/border");
		BorderListModel model = new BorderListModel();
		
		model.setPage(Integer.parseInt(page));
		model.setBorderList(borderListSet.getBorderList(model.getPage()));
		model.setTotalPage(borderListSet.getTotalPage());
		model.setPageStart(borderListSet.getPageStart(model.getPage()));
		model.setPageEnd(borderListSet.getPageEnd(model.getPage()));
		view.addObject("borderModel", model);
		
		return view;
	}
	
	@RequestMapping(value= "/borderinsert", method= RequestMethod.GET)
	public ModelAndView borderInsert(BorderInsertModel borderInsertModel){
		ModelAndView view = new ModelAndView("/border/borderinsert");
		/*
		 * System.out.println(borderInsertModel.getBorder_title());//이미지이름1
		 * System.out.println(borderInsertModel.getFile().getOriginalFilename());//파일의 원래이름, image.jpg
		 * 이렇게 두가지의 버전으로 이름을 두개 받는 이유는 중복이 될경우 이름이 같을때 파일끼리 덮어쓰기가 될 수도 있기 때문이다.
		 * db상에는 다른 이름이 저장될 것이다.
		 * */
		String orginalFile = borderInsertModel.getFile().getOriginalFilename();
		String orginalFileExtention = orginalFile.substring(orginalFile.lastIndexOf("."));
		System.out.println(orginalFileExtention);
		return view;
	}
	
	@RequestMapping(value= "/borderdatainsert", method= RequestMethod.POST)
	public ModelAndView borderDataInsert(BorderInsertModel borderInsertModel, HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView view = new ModelAndView("/border/border");
		//borderInsertService.fileUpload(borderInsertModel);
		borderInsertModel.setUser_ip(request.getRemoteAddr());
		String realPath = request.getRealPath("/jspEx/upload");
		borderInsertService.fileUpload(borderInsertModel);
		return view;
	}
	
	
	@RequestMapping(value= "/borderdtl", method= RequestMethod.GET)//파라메터값이므로 string으로 넘어갈것이다.
	public ModelAndView borderDtl(@RequestParam("border_code")String border_code, 
			@RequestParam("page")String page)
	{
		ModelAndView view = new ModelAndView("/border/borderdtl");
		BorderDtlModel model =  borderDtlService.getBorderDtlModel(border_code);
		model.setPage(page);
		view.addObject("borderDtlModel", model);//"borderDtlModel"을 model에 심어서 객체로 보낸다.
		return view;
	}
	
	
	
}
	
	
	
	
	
	
