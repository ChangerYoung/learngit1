package cn.FixedAssetsManager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cn.FixedAssetsManager.dao.BaseDao;
import cn.FixedAssetsManager.dao.OccupationDao;
/**
 *@author yangxiaoshuo
 *@OccupationDaoImpl
 * create 2016-7-13
 */
public class OccupationDaoImpl extends BaseDao implements OccupationDao{

	@Override
	/**
	 *@ɾ�����е����� 
	 */
	public int del() {
		// TODO Auto-generated method stub
		String sql="delete from Occupation where assets_id=?";
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫɾ���豸��id��");
		int id = input.nextInt();
		Object[] param = {id};
		int result = this.exceuteUpdate(sql, param);
		if(result!=0)
		{
			System.out.println("ɾ���ɹ���");
			return result;
		}
		else
		{
			System.out.println("ɾ��ʧ�ܣ������ڸ�������");
			return result;
		}
	}

	@Override
	/**
	 * @ͨ��id��������
	 * @�ҵ���id�򷵻�true
	 * @û�ҵ�id����false
	 */
	public boolean getByID() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ���ҵ�id��");
		int id = input.nextInt();
		String preparedSql="select * from Occupation where Assets_id=?";
		Object[] param = {id};
		Connection conn = null;// �������Ӷ���
		conn =  getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); 
			if(!rs.next())
			{
				System.out.println("�����ڣ�");
				return false;
			}
			System.out.println("id\t��������\t\t���ù���Ա\t�黹����\t�黹����Ա\t��;\t��ע");
			do{
				System.out.print(rs.getInt("assets_id")+"\t");
				System.out.print(rs.getDate("Occ_date")+"\t");
				System.out.print(rs.getString("Occ_admin")+"\t");
				System.out.print(rs.getDate("back_date")+"\t");
				System.out.print(rs.getString("back_admin")+"\t\t");
				System.out.print(rs.getString("application")+"\t");
				System.out.println(rs.getString("remark")+"\t");
			}
			while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return true;
	}

	@Override
	/**
	 *@����ȫ���軹��Ϣ
	 *@���ҳɹ�����true
	 *@��Ϊ�շ���false 
	 */
	public boolean getAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from occupation ";
		Object[] param = {};
		Connection conn = null;// �������Ӷ���
		conn =  getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); 
			if(!rs.next())
			{
				System.out.println("�����ڣ�");
				return false;
			}
			System.out.println("id\t��������\t\t���ù���Ա\t�黹����\t�黹����Ա\t��;\t��ע");
			do{
				System.out.print(rs.getInt("assets_id")+"\t");
				System.out.print(rs.getDate("Occ_date")+"\t");
				System.out.print(rs.getString("Occ_admin")+"\t");
				System.out.print(rs.getDate("back_date")+"\t");
				System.out.print(rs.getString("back_admin")+"\t\t");
				System.out.print(rs.getString("application")+"\t");
				System.out.println(rs.getString("remark")+"\t");
			}
			while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return true;
	}

	@Override
	/**
	 *@�豸����ʱ�����Ϣ 
	 */
	public int AddOccupation(int Assets_id) {
		// TODO Auto-generated method stub
		String sql="insert into Occupation(Assets_id,Occ_date,Occ_admin,Application,Remark) values(?,?,?,?,?)";
		Scanner input = new Scanner(System.in);
		System.out.println("����������ʱ��(yyyy-mm-dd)��");
		String date = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Occ_Date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���������Ա���ƣ�");
		String Occ_admin = input.next();
		System.out.println("��������;��");
		String Application = input.next();
		System.out.println("������������ƣ�");
		String remark = input.next();
		Object[] param = {Assets_id,date,Occ_admin,Application,remark};
		//�����˸���ĸ��º������и���
		int result = this.exceuteUpdate(sql, param);
		System.out.println("��ӳɹ���");
		return result;
	}

	@Override
	/**
	 *@�豸�黹ʱ�����Ϣ 
	 */
	public int AddBack(int id) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("������黹ʱ��(yyyy-mm-dd)��");
		String date = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Occ_Date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������黹�Ĺ���Ա��");
		String back_admin = input.next();
		String sql="update Occupation set Back_date=?,back_admin=? where Assets_id=?";
		Object[] param = {date,back_admin,id};
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

}
