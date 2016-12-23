package cn.FixedAssetsManager.dao;


/**
 *@author yangxiaoshuo
 *@Class_ManageDao接口
 * create 2016-7-13
 */
public interface Class_ManageDao {
	int Add(String name);//添加大类
	int del(String name);//删除大类
	int update();//更新大类
    boolean getByID();//根据id精确查询大类
	boolean getAll();//获取全部大类信息
	boolean getByClassName(String name);//根据类名查找大类
}
