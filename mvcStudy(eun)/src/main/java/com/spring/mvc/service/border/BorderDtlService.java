package com.spring.mvc.service.border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BorderDAO;
import com.spring.mvc.dao.MybatisBorderDAO;
import com.spring.mvc.model.BorderDtlModel;
import com.spring.mvc.model.beans.BorderBean;

@Service
public class BorderDtlService {
	
	@Autowired
	private BorderDAO borderDAO;

	@Autowired
	private MybatisBorderDAO mybatisBorderDAO;
	
	public BorderDtlModel getBorderDtlModel(String border_code) {
		int i_border_code = Integer.parseInt(border_code);
		
		BorderDtlModel model = new BorderDtlModel();
		//BorderBean borderBean = borderDAO.getBorderDtl(i_border_code);
		BorderBean borderBean = mybatisBorderDAO.getBorderDtl(i_border_code);
		BorderBean borderBean_pre = borderDAO.getPreBorder_Code(i_border_code);
		BorderBean borderBean_next = borderDAO.getNextBorder_Code(i_border_code);
		
		model.setBorder_title(borderBean.getBorder_title());
		model.setBorder_date(borderBean.getBorder_date());
		model.setWriter_name(borderBean.getWriter_name());
		model.setBorder_count(borderBean.getBorder_count());
		model.setBorder_file(borderBean.getBorder_file());
		model.setBorder_content(borderBean.getBorder_content());
		model.setBorder_tempfile(borderBean.getBorder_tempfile());
		model.setBorder_code_pre(borderBean.getBorder_code());
		model.setBorder_title_pre(borderBean.getBorder_title());
		model.setBorder_code_next(borderBean.getBorder_code());
		model.setBorder_title_next(borderBean.getBorder_title());
		//code, title next구현 해야함
		
		return model;
	}
}
