package cn.FixedAssetsManager.dao;

import java.util.List;

import cn.FixedAssetsManager.entity.assets;

/**
 * assetsDao�ӿ�
 * @author ����
 * create 2016-7-13
 */
public interface assetsDao {
	void DisplayAll();//������е��ʲ�������Ϣ
	int Request();//�����ʲ�
	int Return();//�黹�ʲ�
	int Del();//ɾ��ĳ���ʲ�
	int Add();//����ĳ���ʲ�
	int Judge();//�ж��ʲ��ܷ�ʹ��
	public void getById();//����id�����ʲ���Ϣ
	public List<assets> getByUser();//����ʹ���߲����ʲ�
	public List<assets> getByClass();//�����������ʲ�
}
