package com.spring.mvc.service.border;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mvc.dao.MybatisBorderDAO;
import com.spring.mvc.model.BorderInsertModel;
import com.spring.mvc.model.beans.BorderBean;

/**
 *
 * file을 업로드 받아와서 db에 연결하는 서비스, dtl에서는 가져오는 기능을 구현한다.
 * 
 * a1.png = orginalFile
 * 		"."부터 끝까지 잘라낸다(.부터 확장자 명까지 잘라냄)
 * .png = orginalFileExtention
 * tempFile = j12jef72j3.png
 * 		DB에는 두가지의 이름이 같이 저장되어야 한다.
 * 
 * UUID.randomUUID()는 객체 이것을 toString()으로 string으로 바꿔준다.
 * */

@Service
public class BorderInsertService {

	@Autowired
	MybatisBorderDAO mybatisborderDAO;
	
	public void fileUpload(BorderInsertModel borderInsertModel) throws IllegalStateException, IOException {
		MultipartFile multipartFile = borderInsertModel.getFile();
		String orginalFile = borderInsertModel.getFile().getOriginalFilename();
		//원래이름
		String orginalFileExtention = orginalFile.substring(orginalFile.lastIndexOf("."));
		//파일이름에서 확장자를 잘라 확장자만 가져온다.(substring은 글자를 자르는 역할을 한다)
		String tempFile = UUID.randomUUID().toString().replaceAll("-", "") + orginalFileExtention;
		//UUID를 생성하면 중간에 -가 생기는데 그것을 없애기 위해서 replace를 사용한다, 앞서 말한것처럼 만들고 뒤에 가짜이름을 붙인다.
		String filePath = "C:\\김준일강사수업\\fileupload\\";
		File file = new File(filePath + tempFile);
		multipartFile.transferTo(file);
		
		BorderBean borderBean = new BorderBean();
		borderBean.setBorder_title(borderInsertModel.getBorder_title());
		borderBean.setBorder_content(borderInsertModel.getContent_textarea());
		borderBean.setBorder_file(orginalFile);
		borderBean.setBorder_tempfile(tempFile);
		borderBean.setWriter_name(borderInsertModel.getUser_name());
		borderBean.setWriter_ip(borderInsertModel.getUser_ip());
		
		int insertCount = mybatisborderDAO.insertBorder(borderBean);
		
		
	}
}
