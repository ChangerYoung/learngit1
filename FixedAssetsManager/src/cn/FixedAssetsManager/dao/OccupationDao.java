package cn.FixedAssetsManager.dao;

/**
 *@author yangxiaoshuo
 *@Occupation�ӿ� 
 * create 2016-7-13
 */
public interface OccupationDao {
	int AddOccupation(int Assets_id);//���������Ϣ
	int AddBack(int id);//��ӹ黹��Ϣ
	int del();//ɾ��
    boolean getByID();//����id��ȷ��ѯ�軹��Ϣ
	boolean getAll();//��ȡȫ���軹��Ϣ
}
