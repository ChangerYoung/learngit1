package cn.FixedAssetsManager.biz.impl;
/**
 *@author ���� 
 * create 2016-7-13
 */
import java.util.Scanner;
import cn.FixedAssetsManager.dao.assetsDao;
import cn.FixedAssetsManager.dao.impl.assetsDaoImpl;

public class assetsManage {
	/**
	 *��ʾ�ʲ���Ϣ�������ĺ��� 
	 */
	public static void show() {
		boolean con=true;//�û��Ƿ����
		do{
			System.out.println("**********��ӭ����̶��ʲ�����ϵͳ************");			
			System.out.println("\t1.�̶��ʲ���Ϣ����");
			System.out.println("\t2.�ʲ�������");
			System.out.println("\t3.�ʲ��Ĺ黹");
			System.out.println("\t4.�ʲ�����Ϣ���");
			System.out.println("\t5.�ʲ�����Ϣ��ѯ");
			System.out.println("\t0.������һ���˵�");
			System.out.println("**************************************");
			Scanner input=new Scanner(System.in);
			int i=input.nextInt();
			assetsDaoImpl ass=new assetsDaoImpl();
			switch(i){
			case 1:
				boolean con2=true;
				do{
					System.out.println("\t1.�̶��ʲ�������");
					System.out.println("\t2.�̶��ʲ���Ϣ����");
					System.out.println("\t3.������һ���˵�");
					int j=input.nextInt();
					switch(j){
					case 1:
						/**
						 *�̶��ʲ���Ϣ������ 
						 */
						ass.MainClassManager();
						break;
					case 2:
						boolean con3=true;
						do{
							System.out.println("\t1.�����ʲ�");
							System.out.println("\t2.ɾ���ʲ�");
							System.out.println("\t3.������һ���˵�");
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
					System.out.println("\t1.����Ų�ѯ");
					System.out.println("\t2.���ʲ�����ѯ");
					System.out.println("\t3.��ʹ���߲�ѯ");
					System.out.println("\t4.������һ���˵�");
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
