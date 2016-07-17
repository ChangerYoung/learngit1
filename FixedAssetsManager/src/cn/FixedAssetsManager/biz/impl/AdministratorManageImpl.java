package cn.FixedAssetsManager.biz.impl;


/**
 * ����Ա������ʵ��
 * @author �����
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
	String AdName=null;//��¼�û���
	
	@Override
	/**
	 *��½����
	 *create 2016-7-13 
	 */
	public void Login() {
				
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				PreparedStatement pstmt=null;
				String answer = "y";//��ʶ�û��Ƿ����
				
				System.out.println("**********��ӭ�����̶��ʲ�����ϵͳ**********");
				System.out.println("********��ѡ��********");
				System.out.println("****1.����Ա��¼****");
				System.out.println("****0.�˳�****");
				Scanner input=new Scanner(System.in);
				int choice=input.nextInt();
				switch(choice){
				
				case 1:
				{
				System.out.println("******************���¼*******************");
				//step1 ��������
				try
				{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				}
				catch(ClassNotFoundException ex)
				{
					System.out.println(ex);
				}
				//step 2 ��������
				do{
				try
				{
					conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBasename=FixedAssetsManager","test1","123456");
					//step3 ��ѯ����
					System.out.println("**�������û���**");
					
					String name=input.next();
					AdName=name;
					System.out.println("**����������**");			
					String password=input.next();
					
					String sql="select * from Administrator where Admin_name=? and Password=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, password);
					rs=pstmt.executeQuery();
					
					if(rs.next())
					{
						System.out.println("*��¼�ɹ�*");
						/**
						 * ��ʾ������
						 */
						answer="n";
						this.MainMenu();
					}
					else
					{
						System.out.println("*��¼ʧ��*");
						System.out.println("���µ�½��y/n");
						answer=input.next();
					}
					
					
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				}
				//step4 ���ֹر�
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
				System.out.println("**********��ӭ�ٴ�ʹ�ñ�ϵͳ**********");
				break;
				}   
				case 0:
				{
					System.out.println("**********��ӭ�ٴ�ʹ�ñ�ϵͳ**********");
					break;
				}
				}
				
				

			}

	@Override
	/**
	 *���˵����� 
	 */
	public void MainMenu() {
		boolean flag = true;
		while(flag)
		{
		System.out.println("**********��ӭ����̶��ʲ�����ϵͳ**********");
		System.out.println("****��ѡ��****");
		System.out.println("*1.�޸Ĺ���Ա��¼����");
		System.out.println("*2.�ʲ�����");
		System.out.println("*3.��Ա��Ϣ����");
		System.out.println("*0.�˳�");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		switch(choice){
	
		case 1:	
			/**
			 * �޸Ĺ���Ա��¼����
			 */
			String answer ="n";
			do{
			AdministratorDaoImpl ADI=new AdministratorDaoImpl();
			int result=ADI.ChangePassWord(AdName);
			if(result==1){
				System.out.println("�޸ĳɹ�");
				answer ="n";
				
			}else{
				System.out.println("�޸�ʧ��");
				System.out.println("�����޸���y/n");
				answer=input.next();
			}
			}while("y".equals(answer));
			//this.MainMenu();
			break;
			
		case 2:
			/**
			 * �ʲ�����
			 */
			assetsManage am = new assetsManage();
			am.show();
			break;
			
		case 3:
			/**
			 * ��Ա��Ϣ����
			 */
			StaffManage sm = new StaffManageImpl();
			sm.show();
			break;
		case 0:
			/**
			 * �˳�
			 */
			flag = false;
			break;
		}
		}
	}

}

		
	
	


