package com.spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.LoginModel;
import com.spring.mvc.model.beans.UserBean;

@Repository
public class LoginDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int loginCheck(LoginModel loginModel) {
		//model을 전달받는다(전달받는 과정)
		String sql = "select count(*) from user_mst where user_id = ? and user_pwd = ?";
		int flag = jdbcTemplate.queryForObject(sql, new Object[] {loginModel.getLogin_id(), loginModel.getLogin_pwd()},
				/*queryForObject는 하나만 반환한다.
				1. sql을 실행, 오브젝트타입으로 1,2번째 ?에 1,2번째 값이 들어간다. (?에 값을 넣는 부분)
				2. RowMapper가 실행*/
				new RowMapper<Integer>() {
				 
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				//Mapper클래스에서 쓸 객체를 만들어야 하는데 따로 클래스 만들 않고 이러게 무명 클래스를 만들어 데이터를 넘겨출 객체를 생성한다.
				//rowNum, 결과를 조회했을때 나오는 줄(row)의 개수, row에 따른 rs를 반환해준다.
				return rs.getInt(1);
				//int형으로 리턴된다, 이게 flag에 저장된다, id가 있으면 1이 저장되고 없으면 0이 저장된다.
			}
		});
		return flag;
	}
	public UserBean getUserBean(LoginModel loginModel) {
		String sql = "select user_id, user_pwd, user_name, user_birthday from user_mst where user_id = ? and user_pwd = ?";
		
		UserBean userBean = jdbcTemplate.queryForObject(sql, new Object[] {loginModel.getLogin_id(), loginModel.getLogin_pwd()},
				new RowMapper<UserBean>() {
				 
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean bean = new UserBean();
				bean.setUser_id(rs.getString(1));
				bean.setUser_pwd(rs.getString(2));
				bean.setUser_name(rs.getString(3));
				bean.setUser_birthday(rs.getString(4));
				return bean;
			}
		});
		return userBean;
	}
	
}
