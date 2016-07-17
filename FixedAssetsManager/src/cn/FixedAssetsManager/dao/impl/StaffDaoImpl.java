package cn.FixedAssetsManager.dao.impl;

/**
 * 
 * @author ���ĵ�
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cn.FixedAssetsManager.dao.BaseDao;
import cn.FixedAssetsManager.dao.StaffDao;
import cn.FixedAssetsManager.entity.Staff;

public class StaffDaoImpl extends BaseDao implements StaffDao{

	@Override
	/**
	 *�����Ա��Ϣ�ĺ��� 
	 */
	public int save() {
		String sql="insert into staff(Staff_name,Staff_job,Remark) values(?,?,?)";
		Scanner input = new Scanner(System.in);
		System.out.println("������������");
		String Staff_name = input.next();
		System.out.println("������ְ��");
		String Staff_job = input.next();
		System.out.println("�����뱸ע��");
		String Remark = input.next();
		Object[] param = {Staff_name,Staff_job,Remark};
		//�����˸���ĸ��º������и���
		int result = this.exceuteUpdate(sql, param);
		System.out.println("��ӳɹ���");
		return result;
	}

	@Override
	/**
	 *ɾ����Ա��Ϣ�ĺ��� 
	 */
	public int del(Staff staff) {
		String sql="delete from staff where Staff_id=?";
		Object[] param = {staff.getStaff_id()};
		//�����˸���ĸ��º������и���
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 *�޸���Ա��Ϣ�ĺ��� 
	 */
	public int update(Staff staff) {
		Scanner input = new Scanner(System.in);
		//String sql="update dog set love=90 where id=?";
		System.out.println("�������޸����ݣ����磺Staff_name='jerry'");
		String s = input.next();
		String sql="update staff set "+s+" where Staff_id=?";
		Object[] param = {staff.getStaff_id()};
		//�����˸���ĸ��º������и���
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 *���ҵ�ǰ���ݿ���ȫ������Ա��Ϣ 
	 */
	public void getAll() {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff ";
		Object[] param = {};
		Connection conn = null;// �������Ӷ���
		conn = getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); 
			while(rs.next()){
				System.out.print(rs.getInt("Staff_id")+"\t");
				System.out.print(rs.getString("Staff_name")+"\t");
				System.out.print(rs.getString("Staff_job")+"\t");
				System.out.println(rs.getString("Remark")+"\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return ;
		
	}

	@Override
	/**
	 *����id������Ա 
	 */
	public Staff getByID(int id) {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff where Staff_id=?";
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
				System.out.println("û��Ҫ�ҵ�id");
				return null;
			}
			do{
				System.out.print(rs.getInt("Staff_id")+"\t");
				System.out.print(rs.getString("Staff_name")+"\t");
				System.out.print(rs.getString("Staff_job")+"\t");
				System.out.println(rs.getString("Remark")+"\t");
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return null;
	}

	@Override
	/**
	 *�������ֲ�����Ա 
	 */
	public List<Staff> findByName(String name) {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff where Staff_name=?";
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
				System.out.println("û��Ҫ�ҵ�����");
				return null;
			}
			do{
				System.out.print(rs.getInt("Staff_id")+"\t");
				System.out.print(rs.getString("Staff_name")+"\t");
				System.out.print(rs.getString("Staff_job")+"\t");
				System.out.println(rs.getString("Remark")+"\t");
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return null;
	}

}
