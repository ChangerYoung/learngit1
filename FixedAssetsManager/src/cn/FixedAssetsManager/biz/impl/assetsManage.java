package cn.FixedAssetsManager.biz.impl;
/**
 *@author 王祺 
 * create 2016-7-13
 */
import java.util.Scanner;
import cn.FixedAssetsManager.dao.assetsDao;
import cn.FixedAssetsManager.dao.impl.assetsDaoImpl;

public class assetsManage {
	/**
	 *显示资产信息管理界面的函数 
	 */
	public static void show() {
		boolean con=true;//用户是否继续
		do{
			System.out.println("**********欢迎进入固定资产管理系统************");			
			System.out.println("\t1.固定资产信息管理");
			System.out.println("\t2.资产的领用");
			System.out.println("\t3.资产的归还");
			System.out.println("\t4.资产的信息浏览");
			System.out.println("\t5.资产的信息查询");
			System.out.println("\t0.返回上一级菜单");
			System.out.println("**************************************");
			Scanner input=new Scanner(System.in);
			int i=input.nextInt();
			assetsDaoImpl ass=new assetsDaoImpl();
			switch(i){
			case 1:
				boolean con2=true;
				do{
					System.out.println("\t1.固定资产类别管理");
					System.out.println("\t2.固定资产信息管理");
					System.out.println("\t3.返回上一级菜单");
					int j=input.nextInt();
					switch(j){
					case 1:
						/**
						 *固定资产信息管理函数 
						 */
						ass.MainClassManager();
						break;
					case 2:
						boolean con3=true;
						do{
							System.out.println("\t1.增加资产");
							System.out.println("\t2.删除资产");
							System.out.println("\t3.返回上一级菜单");
							int m=input.nextInt();
							switch(m){
							case 1:
								ass.Add();
								break;
							case 2:
								ass.Del();
								break;
							case 3:
								con3=false;
								break;
							}
						}while(con3);
					case 3:
						con2=false;
						break;
					}
				}while(con2);
				break;
			case 2:
				int o=ass.Judge();
				if(o==1)
				ass.Request();
				break;
			case 3:	
				ass.Return();
				break;
			case 4:
				ass.DisplayAll();
				break;
			case 5:
				boolean con4=true;
				do{
					System.out.println("\t1.按编号查询");
					System.out.println("\t2.按资产类别查询");
					System.out.println("\t3.按使用者查询");
					System.out.println("\t4.返回上一级菜单");
					int n=input.nextInt();
					switch(n){
					case 1:
						ass.getById();
						break;
					case 2:
						ass.getByClass();
						break;
					case 3:
						ass.getByUser();
						break;
					case 4:
						con4=false;
						break;
					}
				}while(con4);
				break;
			case 0:
				con=false;
			}	
		}while(con);
		
	}
}
