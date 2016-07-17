package cn.FixedAssetsManager.dao.impl;



import java.util.Scanner;

import cn.FixedAssetsManager.dao.AdministratorDao;
import cn.FixedAssetsManager.dao.BaseDao;

/**
 * 管理员Dao类实现
 * @author 李成洲
 *create 2016-7-13
 */
public class AdministratorDaoImpl extends BaseDao implements AdministratorDao{


	@Override
	/**
	 *修改管理员密码 
	 */
	public int ChangePassWord(String str) {
		System.out.println("请输入新密码：");
		String sql = "update Administrator set Password=? where Admin_name =?";
		Scanner input =new Scanner (System.in);
		String Newpsd=input.next();//新密码
		Object[] param={Newpsd,str};
	    int result =this.exceuteUpdate(sql, param);
	    return result;
	}

}
