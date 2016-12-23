package cn.FixedAssetsManager.dao.impl;
/**
 *@author 王祺
 * create 2016-7-13 
 */

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.FixedAssetsManager.dao.BaseDao;
import cn.FixedAssetsManager.dao.Class_ManageDao;
import cn.FixedAssetsManager.dao.OccupationDao;
import cn.FixedAssetsManager.dao.assetsDao;
import cn.FixedAssetsManager.entity.assets;



/**
 * 实现接口功能
 */
public class assetsDaoImpl extends BaseDao implements assetsDao{



	@Override
	public void DisplayAll() {//资产的浏览
		String sql="select * from Fixed_Assets";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn =  getConnection(conn); 
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getInt(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.print(rs.getInt(7)+"\t");
				System.out.print(rs.getString(8)+"\t");
				System.out.print(rs.getString(9)+"\t\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,stmt,rs);
		}
	}

	@Override
	public int Request() {//领用资产
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要领用的资产id");
		int id=input.nextInt();
		System.out.println("请输入使用者");
		String name=input.next();
		String sql2="update Fixed_Assets set Assets_User=? where Assets_id=?";
		Object[] param={name,id};
		int result=this.exceuteUpdate(sql2, param);
		//修改Occupation表
		OccupationDao od = new OccupationDaoImpl();
		od.AddOccupation(id);
		return result;
	}

	@Override
	public int Return() {//归还资产
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要归还的资产id");
		int id=input.nextInt();
		System.out.println("请输入使用者");
		String name=input.next();
		String sql="update Fixed_Assets set Assets_User=? where Assets_id=?";
		Object[] param={null,id};
		int result=this.exceuteUpdate(sql, param);
		//归还时修改Occupation 表
		OccupationDao od = new OccupationDaoImpl();
		od.AddBack(id);
		return result;
	}

	@Override
	public int Del() {//删除资产
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除的资产id");
		int id=input.nextInt();
		String sql="delete from Fixed_Assets where Assets_id=?";
		Object[] param={id};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	public int DelByName(String name) {//删除资产
		String sql="delete from Fixed_Assets where mainclass=?";
		Object[] param={name};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	@Override
	public int Add() {//增加资产
		Class_ManageDao cm = new Class_ManageDaoImpl();
		Scanner input=new Scanner(System.in);
		//向资产表中添加数据
		System.out.println("请输入要增加的资产name");
		String name=input.next();
		System.out.println("请输入要增加的资产mainclass");
		String mainclass=input.next();
		System.out.println("请输入要增加的资产model");
		String model=input.next();
		System.out.println("请输入要增加的资产value");
		int value=input.nextInt();
		System.out.println("请输入要增加的资产date");
		String date = input.next();
		System.out.println("请输入要增加的资产status");
		int status=input.nextInt();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Occ_Date = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sql="insert into Fixed_Assets (Assets_name,MainClass,Model,Value,Buy_date,Status) values (?,?,?,?,?,?)";
		Object[] param={name,mainclass,model,value,date,status};
		int result=this.exceuteUpdate(sql, param);
		//检查类表中是否有该大类，没有则添加
		//有该大类时,函数返回true,否则返回false
		if(!cm.getByClassName(mainclass))
		{
			cm.Add(mainclass);
		}
		return result;
	}
	
	@Override
	public  void getById() {//根据资产id查找资产（精确查找）
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要查找的资产id");
		int id=input.nextInt();
		String sql="select * from Fixed_Assets where Assets_id='"+id+"'";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn =  getConnection(conn); 
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(!rs.next()){
				System.out.println("没有该ID的资产");
				return ;
			}
			do{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getInt(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.print(rs.getInt(7)+"\t");
				System.out.print(rs.getString(8)+"\t");
				System.out.print(rs.getString(9)+"\t\n");
			}while(rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn,stmt,rs);
		}
	}

	@SuppressWarnings("null")
	@Override
	public List<assets> getByUser() {//根据使用者名来查找资产（模糊查找）
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要查找的资产使用者");
		String name=input.next();
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Fixed_Assets where Assets_User=?";
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
			}else{
				do{
					System.out.print(rs.getInt("Assets_id")+"\t");
					System.out.print(rs.getString("Assets_name")+"\t");
					System.out.print(rs.getString("MainClass")+"\t");
					System.out.print(rs.getString("Model")+"\t");
					System.out.print(rs.getInt("Value")+"\t");
					System.out.print(rs.getString("Buy_date")+"\t");
					System.out.print(rs.getInt("Status")+"\t");
					System.out.print(rs.getString("Assets_User")+"\t");
					System.out.println(rs.getString("Remark")+"\t");
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return null;

	}

	@Override
	public List<assets> getByClass() {//根据资产类查找资产（模糊查找）
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要查找的资产类");
		String mainclass=input.next();
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Fixed_Assets where MainClass=?";
		Object[] param = {mainclass};
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
			}else{
				do{
					System.out.print(rs.getInt("Assets_id")+"\t");
					System.out.print(rs.getString("Assets_name")+"\t");
					System.out.print(rs.getString("MainClass")+"\t");
					System.out.print(rs.getString("Model")+"\t");
					System.out.print(rs.getInt("Value")+"\t");
					System.out.print(rs.getString("Buy_date")+"\t");
					System.out.print(rs.getInt("Status")+"\t");
					System.out.print(rs.getString("Assets_User")+"\t");
					System.out.println(rs.getString("Remark")+"\t");
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return null;

	}

	@Override
	public int Judge() {//判断是否可资产领用，1表示可以，2表示不可以
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要查找的资产id");
		int id=input.nextInt();
		int flag=0;
		String sql="select * from Fixed_Assets where Assets_id='"+id+"'";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn =  getConnection(conn); 
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("找到该资产");
			}
			String user = rs.getString("Assets_User");
			int status = rs.getInt("Status");
			if(user==null&&status==0){
				flag= 1;
				System.out.println("此资产可以领用");
			}else{
				System.out.println("此资产已被占用或正在维修");
				flag =  0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag =  0;
		}finally{
			closeAll(conn,stmt,rs);
		}
		return flag;
	}
	public void MainClassManager()
	{
		boolean flag = true;
		Class_ManageDao CM = new Class_ManageDaoImpl();
		do{
		System.out.println("\t1.增加大类");
		System.out.println("\t2.删除大类");
		System.out.println("\t3.返回上一级菜单");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("请输入要添加的大类名称：");
			String mainClass = input.next();
			CM.Add(mainClass);
			break;
		}
		case 2:
		{
			System.out.println("请输入要删除的大类名称：");
			String name = input.next();
			CM.del(name);
			this.DelByName(name);
			break;
		}
		case 3:
		{
			flag = false;
			break;
		}
		}
		}while(flag==true);
	}

	
	
}
