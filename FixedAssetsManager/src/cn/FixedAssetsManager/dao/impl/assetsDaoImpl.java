package cn.FixedAssetsManager.dao.impl;
/**
 *@author ����
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
 * ʵ�ֽӿڹ���
 */
public class assetsDaoImpl extends BaseDao implements assetsDao{



	@Override
	public void DisplayAll() {//�ʲ������
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
	public int Request() {//�����ʲ�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���õ��ʲ�id");
		int id=input.nextInt();
		System.out.println("������ʹ����");
		String name=input.next();
		String sql2="update Fixed_Assets set Assets_User=? where Assets_id=?";
		Object[] param={name,id};
		int result=this.exceuteUpdate(sql2, param);
		//�޸�Occupation��
		OccupationDao od = new OccupationDaoImpl();
		od.AddOccupation(id);
		return result;
	}

	@Override
	public int Return() {//�黹�ʲ�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�黹���ʲ�id");
		int id=input.nextInt();
		System.out.println("������ʹ����");
		String name=input.next();
		String sql="update Fixed_Assets set Assets_User=? where Assets_id=?";
		Object[] param={null,id};
		int result=this.exceuteUpdate(sql, param);
		//�黹ʱ�޸�Occupation ��
		OccupationDao od = new OccupationDaoImpl();
		od.AddBack(id);
		return result;
	}

	@Override
	public int Del() {//ɾ���ʲ�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ�����ʲ�id");
		int id=input.nextInt();
		String sql="delete from Fixed_Assets where Assets_id=?";
		Object[] param={id};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	public int DelByName(String name) {//ɾ���ʲ�
		String sql="delete from Fixed_Assets where mainclass=?";
		Object[] param={name};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}
	@Override
	public int Add() {//�����ʲ�
		Class_ManageDao cm = new Class_ManageDaoImpl();
		Scanner input=new Scanner(System.in);
		//���ʲ������������
		System.out.println("������Ҫ���ӵ��ʲ�name");
		String name=input.next();
		System.out.println("������Ҫ���ӵ��ʲ�mainclass");
		String mainclass=input.next();
		System.out.println("������Ҫ���ӵ��ʲ�model");
		String model=input.next();
		System.out.println("������Ҫ���ӵ��ʲ�value");
		int value=input.nextInt();
		System.out.println("������Ҫ���ӵ��ʲ�date");
		String date = input.next();
		System.out.println("������Ҫ���ӵ��ʲ�status");
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
		//���������Ƿ��иô��࣬û�������
		//�иô���ʱ,��������true,���򷵻�false
		if(!cm.getByClassName(mainclass))
		{
			cm.Add(mainclass);
		}
		return result;
	}
	
	@Override
	public  void getById() {//�����ʲ�id�����ʲ�����ȷ���ң�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���ҵ��ʲ�id");
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
				System.out.println("û�и�ID���ʲ�");
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
	public List<assets> getByUser() {//����ʹ�������������ʲ���ģ�����ң�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���ҵ��ʲ�ʹ����");
		String name=input.next();
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Fixed_Assets where Assets_User=?";
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
	public List<assets> getByClass() {//�����ʲ�������ʲ���ģ�����ң�
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���ҵ��ʲ���");
		String mainclass=input.next();
		PreparedStatement pstmt = null;
		int num = 0;
		ResultSet rs = null;
		String preparedSql="select * from Fixed_Assets where MainClass=?";
		Object[] param = {mainclass};
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
	public int Judge() {//�ж��Ƿ���ʲ����ã�1��ʾ���ԣ�2��ʾ������
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ���ҵ��ʲ�id");
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
				System.out.println("�ҵ����ʲ�");
			}
			String user = rs.getString("Assets_User");
			int status = rs.getInt("Status");
			if(user==null&&status==0){
				flag= 1;
				System.out.println("���ʲ���������");
			}else{
				System.out.println("���ʲ��ѱ�ռ�û�����ά��");
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
		System.out.println("\t1.���Ӵ���");
		System.out.println("\t2.ɾ������");
		System.out.println("\t3.������һ���˵�");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("������Ҫ��ӵĴ������ƣ�");
			String mainClass = input.next();
			CM.Add(mainClass);
			break;
		}
		case 2:
		{
			System.out.println("������Ҫɾ���Ĵ������ƣ�");
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
