package cn.FixedAssetsManager.dao.impl;



import java.util.Scanner;

import cn.FixedAssetsManager.dao.AdministratorDao;
import cn.FixedAssetsManager.dao.BaseDao;

/**
 * ����ԱDao��ʵ��
 * @author �����
 *create 2016-7-13
 */
public class AdministratorDaoImpl extends BaseDao implements AdministratorDao{


	@Override
	/**
	 *�޸Ĺ���Ա���� 
	 */
	public int ChangePassWord(String str) {
		System.out.println("�����������룺");
		String sql = "update Administrator set Password=? where Admin_name =?";
		Scanner input =new Scanner (System.in);
		String Newpsd=input.next();//������
		Object[] param={Newpsd,str};
	    int result =this.exceuteUpdate(sql, param);
	    return result;
	}

}
