package cn.FixedAssetsManager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cn.FixedAssetsManager.dao.BaseDao;
import cn.FixedAssetsManager.dao.Class_ManageDao;

/**
 * @author yangxiaoshuo
 * @Class_ManageDaoImpl���ʵ�֣����ڶ����ݿ��е�Class_Manage����в��� 
 *  create 2016-7-13
 */
public class Class_ManageDaoImpl extends BaseDao implements Class_ManageDao {

	@Override
	/**
	 *@��class_manage������Ӵ��� 
	 */
	public int Add(String name) {
		// TODO Auto-generated method stub
		String sql="insert into Class_Manage(Main_Class) values(?)";
		Object[] param = {name};
		//�����˸���ĸ��º������и���
		int result = this.exceuteUpdate(sql, param);
		System.out.println("��Ӵ���ɹ���");
		return result;
	}

	@Override
	/**
	 *@��Class_Manage����ɾ������ 
	 */
	public int del(String name) {
		// TODO Auto-generated method stub
		String sql="delete from Class_Manage where Main_Class=?";
		Object[] param = {name};
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
	 *@�޸Ĵ������� 
	 */
	public int update() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�������");
		String prename = input.next();
		System.out.println("�������޸ĺ��������");
		String newname = input.next();
		String sql="update Class_Manage set Main_Class=? where Main_Class=?";
		Object[] param = {newname,prename};
		int result = this.exceuteUpdate(sql, param);
		if(result!=0)
		{
			System.out.println("�޸ĳɹ���");
		}
		else{
			System.out.println("�޸�ʧ�ܣ������ڸ�������");
		}
		return result;
	}

	@Override
	/**
	 * @ͨ��id���Ҵ���
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
		String preparedSql="select * from Class_Manage where Class_id=?";
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
			System.out.println("id\t��������\t");
			do{
				System.out.print(rs.getInt("class_id")+"\t");
				System.out.println(rs.getString("Main_Class")+"\t");
			}
			while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return true;
	}

	/**
	 * @ͨ���������Ҵ���
	 * @�ҵ��ø����򷵻�true
	 * @û�ҵ����෵��false
	 */
	public boolean getByClassName(String name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Class_Manage where Main_class=?";
		Object[] param = {name};
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
			System.out.println("id\t��������\t");
			do{
				System.out.print("�˴����豸���У�"+"\t");
				System.out.print(rs.getInt("class_id")+"\t");
				System.out.println(rs.getString("Main_Class")+"\t");
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
	 *@����ȫ������
	 *@���ҳɹ�����true
	 *@��Ϊ�շ���false 
	 */
	public boolean getAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Class_Manage ";
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
			do{
				System.out.print(rs.getInt("class_id")+"\t");
				System.out.println(rs.getString("Main_Class")+"\t");
			}
			while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return true;
	}

}
