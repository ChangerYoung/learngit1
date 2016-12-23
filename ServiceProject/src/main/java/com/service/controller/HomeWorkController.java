package com.service.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.service.bean.Section;
import com.service.bean.Student;
import com.service.dao.HomeworkDAO;
import com.service.factory.MyBeansFactory;
/*
 * @auto:yangxiaoshuo
 * 时间：2016-12-20
 * HomeWorkController,处理homework相关的请求，返回homework.html
 */
//Controller的声明
@Controller
public class HomeWorkController {
	@RequestMapping("/stu_homework")
	//同名的form表单参数可自动赋值
	public String showHomework(@RequestParam("cou_id" ) String cou_id ,@RequestParam("sec_num" ) int sec_num ,Model model){
		HomeworkDAO HomDAO = (HomeworkDAO)MyBeansFactory.getBeans("homeworkdao");
		//从数据库中获取相应数据，可在com.service.dao包中自定义SQL语句
		Section section = HomDAO.getHomeworkBycou_idAndsec_num(cou_id, sec_num);
		System.out.println("id= "+cou_id+" "+sec_num+" ");
		if(section==null){
			model.addAttribute("error_text","该课程不存在");
			return "error";
		}
		else{
			model.addAttribute("cou_id", cou_id);
			model.addAttribute("sec_num", sec_num);
			model.addAttribute("section", section);
		    return "homework";
	    }
	}
	
	@RequestMapping("/tea_homework")
	//同名的form表单参数可自动赋值
	public String toAddHomework(@RequestParam("cou_id" ) String cou_id ,@RequestParam("sec_num" ) int sec_num ,Model model){
		HomeworkDAO HomDAO = (HomeworkDAO)MyBeansFactory.getBeans("homeworkdao");
		//从数据库中获取相应数据，可在com.service.dao包中自定义SQL语句
		Section section = HomDAO.getHomeworkBycou_idAndsec_num(cou_id, sec_num);
		System.out.println("id= "+cou_id+" "+sec_num+" ");
		if(section==null){
			model.addAttribute("error_text","该课程不存在");
			return "error";
		}
		else{
			model.addAttribute("cou_id", cou_id);
			model.addAttribute("sec_num", sec_num);
			model.addAttribute("section", section);
		    return "addHomework";
	    }
	}

	@RequestMapping("/tea_addHomework")
	//同名的form表单参数可自动赋值
	public String addHomework(@RequestParam("cou_id" ) String cou_id ,@RequestParam("sec_num" ) int sec_num , @RequestParam("sec_homework" ) String sec_homework ,@RequestParam("sec_home_ans" ) String sec_home_ans , Model model){
		Date sec_time = new Date(System.currentTimeMillis());
		HomeworkDAO HomDAO = (HomeworkDAO)MyBeansFactory.getBeans("homeworkdao");
		HomDAO.updateHomework(sec_homework, sec_time, sec_home_ans, cou_id, sec_num);
		return "success";
	}
}
