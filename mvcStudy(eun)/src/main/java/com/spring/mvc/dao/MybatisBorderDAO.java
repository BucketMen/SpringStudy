package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.model.beans.BorderBean;

public interface MybatisBorderDAO {
	public List<BorderBean> getBorderList();
	public BorderBean getBorderDtl(int border_code);
	public Integer insertBorder(BorderBean borderBean);//마이바티스는 몇개가 반환되었는지를 반환해 준다 즉int
	
}
