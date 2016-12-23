package cn.FixedAssetsManager.entity;


/**
 * 资产实体类
 * @author 王祺
 *  create 2016-7-13
 */
public class assets {
	
	private	int Assets_id;//设备编号
	private String Assets_name;//设备名称
	private String MainClass;//设备所属大类
	private String Model;//设备型号
	private int Value;//设备价值
	private String Buy_date;//购买日期
	private int Status;//资产状态：0：正常 1：维修 2：报废
	private String Assets_User;//使用者
	private String Remark;//备注
	public int getAssets_id() {
		return Assets_id;
	}
	public void setAssets_id(int assets_id) {
		Assets_id = assets_id;
	}
	public String getAssets_name() {
		return Assets_name;
	}
	public void setAssets_name(String assets_name) {
		Assets_name = assets_name;
	}
	public String getMainClass() {
		return MainClass;
	}
	public void setMainClass(String mainClass) {
		MainClass = mainClass;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public String getBuy_date() {
		return Buy_date;
	}
	public void setBuy_date(String buy_date) {
		Buy_date = buy_date;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getAssets_User() {
		return Assets_User;
	}
	public void setAssets_User(String assets_User) {
		Assets_User = assets_User;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
