package cn.FixedAssetsManager.dao.impl;

/**
 * 
 * @author 赵文迪
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
	 *添加人员信息的函数 
	 */
	public int save() {
		String sql="insert into staff(Staff_name,Staff_job,Remark) values(?,?,?)";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String Staff_name = input.next();
		System.out.println("请输入职务：");
		String Staff_job = input.next();
		System.out.println("请输入备注：");
		String Remark = input.next();
		Object[] param = {Staff_name,Staff_job,Remark};
		//调用了父类的更新函数进行更新
		int result = this.exceuteUpdate(sql, param);
		System.out.println("添加成功！");
		return result;
	}

	@Override
	/**
	 *删除人员信息的函数 
	 */
	public int del(Staff staff) {
		String sql="delete from staff where Staff_id=?";
		Object[] param = {staff.getStaff_id()};
		//调用了父类的更新函数进行更新
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 *修改人员信息的函数 
	 */
	public int update(Staff staff) {
		Scanner input = new Scanner(System.in);
		//String sql="update dog set love=90 where id=?";
		System.out.println("请输入修改内容：例如：Staff_name='jerry'");
		String s = input.next();
		String sql="update staff set "+s+" where Staff_id=?";
		Object[] param = {staff.getStaff_id()};
		//调用了父类的更新函数进行更新
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	/**
	 *查找当前数据库中全部的人员信息 
	 */
	public void getAll() {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff ";
		Object[] param = {};
		Connection conn = null;// 数据连接对象
		conn = getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
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
	 *根据id查找人员 
	 */
	public Staff getByID(int id) {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff where Staff_id=?";
		Object[] param = {id};
		Connection conn = null;// 数据连接对象
		conn =  getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); 
			if(!rs.next())
			{
				System.out.println("没有要找的id");
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
	 *根据名字查找人员 
	 */
	public List<Staff> findByName(String name) {
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from staff where Staff_name=?";
		Object[] param = {name};
		Connection conn = null;// 数据连接对象
		conn =  getConnection(conn); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			
			rs = pstmt.executeQuery(); 
			if(!rs.next())
			{
				System.out.println("没有要找的名字");
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
