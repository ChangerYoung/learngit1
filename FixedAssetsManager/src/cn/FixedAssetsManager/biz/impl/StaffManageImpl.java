package cn.FixedAssetsManager.biz.impl;


/**
 * 
 * @author 赵文迪
 * create 2016-7-13
 */
import java.util.Scanner;

import cn.FixedAssetsManager.biz.StaffManage;
import cn.FixedAssetsManager.dao.StaffDao;
import cn.FixedAssetsManager.dao.impl.StaffDaoImpl;
import cn.FixedAssetsManager.entity.Staff;

public class StaffManageImpl implements StaffManage{

	@Override
	public void show() {
		Scanner input = new Scanner(System.in);
		Staff staff=new Staff();
		boolean flag = true;
		StaffDao staffdao = new StaffDaoImpl();
		while(flag)
		{
			System.out.println("##########欢迎使用员工管理系统###########");
			System.out.println("1.	查看所有员工信息");
			System.out.println("2.	添加员工信息");
			System.out.println("3.	删除员工信息");
			System.out.println("4.	更新员工信息");
			System.out.println("5.	查找员工信息");
			System.out.println("6、	返回上一级菜单");
			System.out.println("请输入：");
			int choice = input.nextInt();
			switch(choice)
			{
			case 1:
			{
				/*****************查看所有员工信息*******************/
				staffdao.getAll();
				System.out.println("操作成功！");
				break;
			}
			case 2:
			{
				/*****************添加员工信息*******************/
				staffdao.save();
				break;
			}
			case 3:
			{
				/*****************删除员工信息*******************/
				System.out.println("请输入删除的id");
				int id = input.nextInt();
				staff.setStaff_id(id);
				int result = staffdao.del(staff);
				if(result==1)
				{
					System.out.println("删除成功");
				}
				else {
					System.out.println("删除失败");
				}
				break;
			}
			case 4:
			{
				/*****************更新员工信息*******************/
				System.out.println("请输入修改的id");
				int id = input.nextInt();
				staff.setStaff_id(id);
				int result = staffdao.update(staff);
				if(result!=0)
				{
					System.out.println("更新成功");
				}
				else {
					System.out.println("更新失败,没找到当前id");
				}
				break;
			}
			case 5:
			{
				/*****************查找员工信息*******************/
				System.out.println("请输入查找类型：1代表id查找，2代表名字查找");
				int type = input.nextInt();
				switch(type)
				{
					case 1:
					{
						//根据id精确查找
						System.out.println("请输入查找的id：");
						int id = input.nextInt();
						staffdao.getByID(id);
						break;
					}
					case 2:
					{
						//根据名字模糊查找
						System.out.println("请输入查找的名称：");
						String name = input.next();
						staffdao.findByName(name);
						break;
					}
				}
				break;
			}
			case 6:
			{
				/*****************返回上一级菜单*******************/
				flag = false;
			}
			}
	}
	}

}
