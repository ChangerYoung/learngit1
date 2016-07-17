package cn.FixedAssetsManager.dao;

import java.util.List;

import cn.FixedAssetsManager.entity.Staff;

/**
 * 
 * @author 赵文迪
 *  create 2016-7-13
 */

public interface StaffDao { 
	int save();//保存信息
	int del(Staff staff);//删除员工信息
	int update(Staff staff);//更新信息
	void getAll();//获取全部员工信息
	Staff getByID(int id);//根据id精确查询
	List<Staff> findByName(String name);//根据名字查询
}
