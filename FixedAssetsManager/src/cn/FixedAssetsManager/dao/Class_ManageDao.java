package cn.FixedAssetsManager.dao;


/**
 *@author yangxiaoshuo
 *@Class_ManageDao�ӿ�
 * create 2016-7-13
 */
public interface Class_ManageDao {
	int Add(String name);//��Ӵ���
	int del(String name);//ɾ������
	int update();//���´���
    boolean getByID();//����id��ȷ��ѯ����
	boolean getAll();//��ȡȫ��������Ϣ
	boolean getByClassName(String name);//�����������Ҵ���
}
