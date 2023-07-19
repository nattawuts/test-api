package th.example.thailifetest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentModel {
	
	@Id
	private String deptId;
	private String deptName;
	private String deptOrgCode;
	private String deptCreateDate;
	private String deptUpdateDate;
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptOrgCode() {
		return deptOrgCode;
	}
	public void setDeptOrgCode(String deptOrgCode) {
		this.deptOrgCode = deptOrgCode;
	}
	public String getDeptCreateDate() {
		return deptCreateDate;
	}
	public void setDeptCreateDate(String deptCreateDate) {
		this.deptCreateDate = deptCreateDate;
	}
	public String getDeptUpdateDate() {
		return deptUpdateDate;
	}
	public void setDeptUpdateDate(String deptUpdateDate) {
		this.deptUpdateDate = deptUpdateDate;
	}

}
