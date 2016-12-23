package cn.FixedAssetsManager.test;
import cn.FixedAssetsManager.*;
import cn.FixedAssetsManager.biz.*;
import cn.FixedAssetsManager.biz.impl.*;
import cn.FixedAssetsManager.dao.*;
import cn.FixedAssetsManager.dao.impl.*;
import cn.FixedAssetsManager.entity.*;
import cn.FixedAssetsManager.dao.Class_ManageDao;
import cn.FixedAssetsManager.dao.impl.Class_ManageDaoImpl;
import cn.FixedAssetsManager.dao.impl.OccupationDaoImpl;
/**
 *@author yangxiaoshuo 
 * create 2016-7-13
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdministratorManage am = new AdministratorManageImpl();
		StaffManage sm = new StaffManageImpl();
		am.Login();
	}

}


//Ìí¼ÓÐÞ¸Ä
