package cn.FixedAssetsManager.biz.impl;


/**
 * 管理员管理类实现
 * @author 李成洲
 *create 2016-7-13
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cn.FixedAssetsManager.biz.AdministratorManage;
import cn.FixedAssetsManager.biz.StaffManage;
import cn.FixedAssetsManager.dao.impl.AdministratorDaoImpl;

import java.sql.PreparedStatement;

public class AdministratorManageImpl implements AdministratorManage {
	String AdName=null;//记录用户名
	
	@Override
	/**
	 *登陆界面
	 *create 2016-7-13 
	 */
	public void Login() {
				
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				PreparedStatement pstmt=null;
				String answer = "y";//标识用户是否继续
				
				System.out.println("**********欢迎来到固定资产管理系统**********");
				System.out.println("********请选择********");
				System.out.println("****1.管理员登录****");
				System.out.println("****0.退出****");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				
				case 1:
				{
				System.out.println("******************请登录*******************");
				//step1 加载驱动
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				}
				catch(ClassNotFoundException ex)
				{
					System.out.println(ex);
				}
				//step 2 建立连接
				do{
				try
				{
					conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBasename=FixedAssetsManager","test1","123456");
					//step3 查询数据
					System.out.println("**请输入用户名**");
					
					String name=input.next();
					AdName=name;
					System.out.println("**请输入密码**");			
					String password=input.next();
					
					String sql="select * from Administrator where Admin_name=? and Password=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, password);
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						System.out.println("*登录成功*");
						/**
						 * 显示主界面
						 */
						answer="n";
						this.MainMenu();
					}
					else
					{
						System.out.println("*登录失败*");
						System.out.println("重新登陆吗？y/n");
						answer=input.next();
					}
					
					
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				}
				//step4 各种关闭
				finally
				{
					try
					{
						if(rs!=null)
						{
							rs.close();
						}
						if(pstmt!=null)
						{
							pstmt.close();
						}
						if(stmt!=null)
						{
							stmt.close();
						}
						if(conn!=null)
						{
							conn.close();
						}
					}
					catch(SQLException ex)
					{
						System.out.println(ex);
					}
				}
				}while("y".equals(answer));
				System.out.println("**********欢迎再次使用本系统**********");
				break;
				}   
				case 0:
				{
					System.out.println("**********欢迎再次使用本系统**********");
					break;
				}
				}
				
				

			}

	@Override
	/**
	 *主菜单界面 
	 */
	public void MainMenu() {
		boolean flag = true;
		while(flag)
		{
		System.out.println("**********欢迎进入固定资产管理系统**********");
		System.out.println("****请选择****");
		System.out.println("*1.修改管理员登录密码");
		System.out.println("*2.资产管理");
		System.out.println("*3.人员信息管理");
		System.out.println("*0.退出");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch(choice){
	
		case 1:	
			/**
			 * 修改管理员登录密码
			 */
			String answer ="n";
			do{
			AdministratorDaoImpl ADI=new AdministratorDaoImpl();
			int result=ADI.ChangePassWord(AdName);
			if(result==1){
				System.out.println("修改成功");
				answer ="n";
				
			}else{
				System.out.println("修改失败");
				System.out.println("重新修改吗？y/n");
				answer=input.next();
			}
			}while("y".equals(answer));
			//this.MainMenu();
			break;
			
		case 2:
			/**
			 * 资产管理
			 */
			assetsManage am = new assetsManage();
			am.show();
			break;
			
		case 3:
			/**
			 * 人员信息管理
			 */
			StaffManage sm = new StaffManageImpl();
			sm.show();
			break;
		case 0:
			/**
			 * 退出
			 */
			flag = false;
			break;
		}
		}
	}

}

		
	
	


