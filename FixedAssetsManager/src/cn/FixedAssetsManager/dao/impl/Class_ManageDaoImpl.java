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
 * @Class_ManageDaoImpl类的实现，用于对数据库中的Class_Manage表进行操作 
 *  create 2016-7-13
 */
public class Class_ManageDaoImpl extends BaseDao implements Class_ManageDao {

	@Override
	/**
	 *@向class_manage表中添加大类 
	 */
	public int Add(String name) {
		// TODO Auto-generated method stub
		String sql="insert into Class_Manage(Main_Class) values(?)";
		Object[] param = {name};
		//调用了父类的更新函数进行更新
		int result = this.exceuteUpdate(sql, param);
		System.out.println("添加大类成功！");
		return result;
	}

	@Override
	/**
	 *@在Class_Manage表中删除大类 
	 */
	public int del(String name) {
		// TODO Auto-generated method stub
		String sql="delete from Class_Manage where Main_Class=?";
		Object[] param = {name};
		int result = this.exceuteUpdate(sql, param);
		if(result!=0)
		{
			System.out.println("删除成功！");
			return result;
		}
		else
		{
			System.out.println("删除失败，不存在该类名！");
			return result;
		}
		
	}

	@Override
	/**
	 *@修改大类名称 
	 */
	public int update() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要修改的类名：");
		String prename = input.next();
		System.out.println("请输入修改后的类名：");
		String newname = input.next();
		String sql="update Class_Manage set Main_Class=? where Main_Class=?";
		Object[] param = {newname,prename};
		int result = this.exceuteUpdate(sql, param);
		if(result!=0)
		{
			System.out.println("修改成功！");
		}
		else{
			System.out.println("修改失败，不存在该类名！");
		}
		return result;
	}

	@Override
	/**
	 * @通过id查找大类
	 * @找到该id则返回true
	 * @没找到id返回false
	 */
	public boolean getByID() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要查找的id：");
		int id = input.nextInt();
		String preparedSql="select * from Class_Manage where Class_id=?";
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
				System.out.println("不存在！");
				return false;
			}
			System.out.println("id\t大类名称\t");
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
	 * @通过类名查找大类
	 * @找到该该类则返回true
	 * @没找到该类返回false
	 */
	public boolean getByClassName(String name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Class_Manage where Main_class=?";
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
				System.out.println("不存在！");
				return false;
			}
			System.out.println("id\t大类名称\t");
			do{
				System.out.print("此大类设备还有："+"\t");
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
	 *@查找全部大类
	 *@查找成功返回true
	 *@表为空返回false 
	 */
	public boolean getAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Class_Manage ";
		Object[] param = {};
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
				System.out.println("不存在！");
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
