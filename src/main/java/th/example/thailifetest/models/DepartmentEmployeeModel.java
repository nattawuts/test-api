package th.example.thailifetest.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "deparement")
public class DepartmentEmployeeModel {
	
	@Id
	private String deptId;
	private String deptName;
	private String employeeName;
	
	@Transient
	private List<DepartmentEmployeeModel> listTeam;
	
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public List<DepartmentEmployeeModel> getListTeam() {
		return listTeam;
	}
	public void setListTeam(List<DepartmentEmployeeModel> listTeam) {
		this.listTeam = listTeam;
	}
	
	
}
