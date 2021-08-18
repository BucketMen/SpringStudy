package com.spring.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.beans.BorderBean;

@Repository
public class MybatisBorderDAOImpl implements MybatisBorderDAO{
	
	@Autowired
	private SqlSession session;
	
	private static final String NAME_SPACE = "com.spring.mvc.MyBatisBorderDAO"; 
	
	
	@Override
	public List<BorderBean> getBorderList() {
		
		return session.selectList(NAME_SPACE + ".getBorderList");
	}
	
	@Override
	public BorderBean getBorderDtl(int border_code) {
		return session.selectOne(NAME_SPACE + ".getBorderList", border_code);//border-mapper에 매개변수로 이동한다.
	}
}
