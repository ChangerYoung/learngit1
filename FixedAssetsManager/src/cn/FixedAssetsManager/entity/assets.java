package cn.FixedAssetsManager.entity;


/**
 * �ʲ�ʵ����
 * @author ����
 *  create 2016-7-13
 */
public class assets {
	
	private	int Assets_id;//�豸���
	private String Assets_name;//�豸����
	private String MainClass;//�豸��������
	private String Model;//�豸�ͺ�
	private int Value;//�豸��ֵ
	private String Buy_date;//��������
	private int Status;//�ʲ�״̬��0������ 1��ά�� 2������
	private String Assets_User;//ʹ����
	private String Remark;//��ע
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
