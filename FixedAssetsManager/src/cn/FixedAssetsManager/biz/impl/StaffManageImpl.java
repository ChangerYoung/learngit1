package cn.FixedAssetsManager.biz.impl;


/**
 * 
 * @author ���ĵ�
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
			System.out.println("##########��ӭʹ��Ա������ϵͳ###########");
			System.out.println("1.	�鿴����Ա����Ϣ");
			System.out.println("2.	���Ա����Ϣ");
			System.out.println("3.	ɾ��Ա����Ϣ");
			System.out.println("4.	����Ա����Ϣ");
			System.out.println("5.	����Ա����Ϣ");
			System.out.println("6��	������һ���˵�");
			System.out.println("�����룺");
			int choice = input.nextInt();
			switch(choice)
			{
			case 1:
			{
				/*****************�鿴����Ա����Ϣ*******************/
				staffdao.getAll();
				System.out.println("�����ɹ���");
				break;
			}
			case 2:
			{
				/*****************���Ա����Ϣ*******************/
				staffdao.save();
				break;
			}
			case 3:
			{
				/*****************ɾ��Ա����Ϣ*******************/
				System.out.println("������ɾ����id");
				int id = input.nextInt();
				staff.setStaff_id(id);
				int result = staffdao.del(staff);
				if(result==1)
				{
					System.out.println("ɾ���ɹ�");
				}
				else {
					System.out.println("ɾ��ʧ��");
				}
				break;
			}
			case 4:
			{
				/*****************����Ա����Ϣ*******************/
				System.out.println("�������޸ĵ�id");
				int id = input.nextInt();
				staff.setStaff_id(id);
				int result = staffdao.update(staff);
				if(result!=0)
				{
					System.out.println("���³ɹ�");
				}
				else {
					System.out.println("����ʧ��,û�ҵ���ǰid");
				}
				break;
			}
			case 5:
			{
				/*****************����Ա����Ϣ*******************/
				System.out.println("������������ͣ�1����id���ң�2�������ֲ���");
				int type = input.nextInt();
				switch(type)
				{
					case 1:
					{
						//����id��ȷ����
						System.out.println("��������ҵ�id��");
						int id = input.nextInt();
						staffdao.getByID(id);
						break;
					}
					case 2:
					{
						//��������ģ������
						System.out.println("��������ҵ����ƣ�");
						String name = input.next();
						staffdao.findByName(name);
						break;
					}
				}
				break;
			}
			case 6:
			{
				/*****************������һ���˵�*******************/
				flag = false;
			}
			}
	}
	}

}
