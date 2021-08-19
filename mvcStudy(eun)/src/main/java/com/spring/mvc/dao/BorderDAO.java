package com.spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.BorderInsertModel;
import com.spring.mvc.model.beans.BorderBean;

/**
 * 
 * DAO data access object
 *
 * service: 서비스 관련 컴포넌트 controller: 컨트롤러 컴포넌트 Repository: db관련 컴포넌트
 */

@Repository
public class BorderDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ArrayList<BorderBean> getBorderList() {
		String sql = "select * from border_mst order 	by border_code desc";
		ArrayList<BorderBean> list = (ArrayList<BorderBean>) jdbcTemplate.query(sql, new RowMapper<BorderBean>() {
			/*
			 * jdbcTemplate.query는 row의 모든 데이터를 담는 메소드, 안에 while이 생략되어있다, 즉 내부 코드들이 반복, 모든
			 * row를 담는다. rowNum만큼 반복된다. 데이터를 매핑해주는 역할을 할 뿐, DB에서 가져오는 메소드가 아님을 기억하자 rs: 현재의
			 * row값이 들어있다, rowNum에 매핑이 되어있다, rowNum으로 rs값을 이동할수 있다. 다 담긴걸 query가 리턴한다.
			 */

			@Override
			public BorderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				BorderBean borderBean = new BorderBean();

				borderBean.setBorder_code(rs.getInt(1));
				borderBean.setBorder_title(rs.getString(2));
				borderBean.setBorder_content(rs.getString(3));
				borderBean.setBorder_file(rs.getString(4));
				borderBean.setWriter_name(rs.getString(5));
				borderBean.setWriter_ip(rs.getString(6));
				borderBean.setBorder_date(rs.getString(7));
				borderBean.setBorder_count(rs.getInt(8));

				return borderBean;
				// 무명클래스
			}
		});
		return list;
	}

	public void insertBorder(BorderInsertModel borderInsertModel) {
		String sql = "Insert into border_mst values(0, ?, ?, ?, ?, ? , now(), 0, now(), now())";
		jdbcTemplate.update(sql, borderInsertModel.getBorder_title(), borderInsertModel.getContent_textarea(),
				borderInsertModel.getFile(), borderInsertModel.getUser_name(), borderInsertModel.getUser_ip());
	}

	public BorderBean getBorderDtl(int border_code) {
		String sql = "select * from border_mst where border_code = ?";
		BorderBean borderBean = jdbcTemplate.queryForObject(sql, new Object[] { border_code },
				new RowMapper<BorderBean>() {
					@Override
					public BorderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						BorderBean bean = new BorderBean();
						bean.setBorder_code(rs.getInt(1));
						bean.setBorder_title(rs.getString(2));
						bean.setBorder_content(rs.getString(3));
						bean.setBorder_file(rs.getString(4));
						bean.setWriter_name(rs.getString(5));
						bean.setWriter_ip(rs.getString(6));
						bean.setBorder_date(rs.getString(7));
						bean.setBorder_count(rs.getInt(8));
						return bean;// return된 bean이 BorderBean에 들어간다.
					}
				});
		return borderBean;
	}

	public BorderBean getPreBorder_Code(int border_code) {
		// 나보다 이전의 게시물을 가져오고자 한다(border_code를 기준으로 가져온다)
		String sql = "select border_code, border_title from border_mst where border_code = "
				+ "(select max(border_code) from border_mst border_mst where border_code < ?)";
		// 나보다 크면서 그중에서 제일 작은 코드를 불러온다.(단 보더코드는 순서대로 정렬되어있다.)

		BorderBean borderBean = jdbcTemplate.queryForObject(sql, new Object[] {border_code}, // query만 하면 모든 row를 가져와서 객체에 저장한다, queryForObject는 하나만 가져온다.
				 new RowMapper<BorderBean>() {
					@Override
					public BorderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						BorderBean bean = new BorderBean();
						bean.setBorder_code(rs.getInt(1));
						bean.setBorder_title(rs.getString(2));
						return bean;
					}
				 });
		
		return borderBean;
		//service로 간다?
	}
	public BorderBean getNextBorder_Code(int border_code) {
		String sql = "select border_code, border_title from border_mst where border_code = "
				+ "(select min(border_code) from border_mst border_mst where border_code > ?)";
		BorderBean borderBean = jdbcTemplate.queryForObject(sql, new Object[] {border_code}, 
				 new RowMapper<BorderBean>() {
					@Override
					public BorderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						BorderBean bean = new BorderBean();
						bean.setBorder_code(rs.getInt(1));
						bean.setBorder_title(rs.getString(2));
						return bean;
					}
				 });
		return borderBean;
	}

}
