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
	 *@删除表中的数据 
	 */
	public int del() {
		// TODO Auto-generated method stub
		String sql="delete from Occupation where assets_id=?";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要删除设备的id：");
		int id = input.nextInt();
		Object[] param = {id};
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
	 * @通过id查找数据
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
		String preparedSql="select * from Occupation where Assets_id=?";
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
			System.out.println("id\t领用日期\t\t领用管理员\t归还日期\t归还管理员\t用途\t备注");
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
	 *@查找全部借还信息
	 *@查找成功返回true
	 *@表为空返回false 
	 */
	public boolean getAll() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from occupation ";
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
			System.out.println("id\t领用日期\t\t领用管理员\t归还日期\t归还管理员\t用途\t备注");
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
	 *@设备领用时添加信息 
	 */
	public int AddOccupation(int Assets_id) {
		// TODO Auto-generated method stub
		String sql="insert into Occupation(Assets_id,Occ_date,Occ_admin,Application,Remark) values(?,?,?,?,?)";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入领用时间(yyyy-mm-dd)：");
		String date = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Occ_Date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请输入管理员名称：");
		String Occ_admin = input.next();
		System.out.println("请输入用途：");
		String Application = input.next();
		System.out.println("请输入大类名称：");
		String remark = input.next();
		Object[] param = {Assets_id,date,Occ_admin,Application,remark};
		//调用了父类的更新函数进行更新
		int result = this.exceuteUpdate(sql, param);
		System.out.println("添加成功！");
		return result;
	}

	@Override
	/**
	 *@设备归还时添加信息 
	 */
	public int AddBack(int id) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入归还时间(yyyy-mm-dd)：");
		String date = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Occ_Date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请输入归还的管理员：");
		String back_admin = input.next();
		String sql="update Occupation set Back_date=?,back_admin=? where Assets_id=?";
		Object[] param = {date,back_admin,id};
		int result = this.exceuteUpdate(sql, param);
		return result;
	}

}
