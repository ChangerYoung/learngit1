package com.service.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.service.bean.Section;

public interface HomeworkDAO {
	//@Select("select * from section where stu_email=#{stu_email}")
	//public Section getStuByStu_email(String stu_email);
	
	@Select("select * from section where cou_id=#{0} and sec_num=#{1}")
	public Section getHomeworkBycou_idAndsec_num(String cou_id, int sec_num);
	
	//@Select("select * from section")
	//public List<Section> getAllStu();
	
	@Insert("update section set sec_homework = #{0},sec_time=#{1},sec_home_ans =#{2} where cou_id=#{3} and sec_num=#{4}")
	public void updateHomework(String sec_homework,Date sec_time,String sec_home_ans,String cou_id,int sec_num);
	
	//@Delete("delete from section where stu_email=#{stu_email}")
	//public void deleteStuByStu_email(String stu_email);
	
}
