package cn.FixedAssetsManager.entity;

/**
 * 
 * @author 赵文迪
 *  create 2016-7-13
 */
public class Staff {
	private int Staff_id;//员工编号
	private String Staff_name;//员工姓名
	private String Staff_job;//员工职位
	private String  Remark;//备注
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	public String getStaff_name() {
		return Staff_name;
	}
	public void setStaff_name(String staff_name) {
		Staff_name = staff_name;
	}
	public String getStaff_job() {
		return Staff_job;
	}
	public void setStaff_job(String staff_job) {
		Staff_job = staff_job;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
