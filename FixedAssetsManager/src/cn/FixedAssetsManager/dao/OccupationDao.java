package cn.FixedAssetsManager.dao;

/**
 *@author yangxiaoshuo
 *@Occupation接口 
 * create 2016-7-13
 */
public interface OccupationDao {
	int AddOccupation(int Assets_id);//添加领用信息
	int AddBack(int id);//添加归还信息
	int del();//删除
    boolean getByID();//根据id精确查询借还信息
	boolean getAll();//获取全部借还信息
}
