package com.chinaredstar.cd.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaredstar.cd.dao.UserMapper;
import com.chinaredstar.cd.dao.Users2Mapper;
import com.chinaredstar.cd.pojo.User;
import com.chinaredstar.cd.pojo.Users2;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	Users2Mapper user2Mapper;

	@Override
	public List<User> getUser(int age) {
		return userMapper.getUser(age);
	}

	@Override
	public Users2 selectByPrimaryKey(Integer id) {
		return user2Mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Users2> getUsers() {
		return user2Mapper.getUsers();
	}

	@Override
	public HSSFWorkbook export() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("信息表");
		List<Users2> userDetails = getUsers();

		// 新增数据行，并且设置单元格数据
		int rowNum = 1;

		// headers表示excel表中第一行的表头 在excel表中添加表头
		String[] headers = { "id", "age", "username", "phone", "email" };
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 在表中存放查询到的数据放入对应的列
		for (Users2 item : userDetails) {
			HSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell(0).setCellValue(item.getId());
			row1.createCell(1).setCellValue(item.getAge());
			row1.createCell(2).setCellValue(item.getUsername());
			row1.createCell(3).setCellValue(item.getPhone());
			row1.createCell(3).setCellValue(item.getEmail());
			rowNum++;
		}

		return workbook;

	}

}
