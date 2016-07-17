package cn.FixedAssetsManager.dao;

import java.util.List;

import cn.FixedAssetsManager.entity.assets;

/**
 * assetsDao接口
 * @author 王祺
 * create 2016-7-13
 */
public interface assetsDao {
	void DisplayAll();//浏览所有的资产及其信息
	int Request();//领用资产
	int Return();//归还资产
	int Del();//删除某个资产
	int Add();//增加某个资产
	int Judge();//判断资产能否使用
	public void getById();//根据id查找资产信息
	public List<assets> getByUser();//根据使用者查找资产
	public List<assets> getByClass();//根据类别查找资产
}
