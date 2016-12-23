package cn.FixedAssetsManager.dao;

import java.util.List;

import cn.FixedAssetsManager.entity.Staff;

/**
 * 
 * @author ���ĵ�
 *  create 2016-7-13
 */

public interface StaffDao { 
	int save();//������Ϣ
	int del(Staff staff);//ɾ��Ա����Ϣ
	int update(Staff staff);//������Ϣ
	void getAll();//��ȡȫ��Ա����Ϣ
	Staff getByID(int id);//����id��ȷ��ѯ
	List<Staff> findByName(String name);//�������ֲ�ѯ
}
