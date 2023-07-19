package th.example.thailifetest.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "employee_detail")
public class EmployeeDetailModel {

	@Id
	private String employeeId;
	private String employeeName;
	private Date birthdate;
	private String mobileNo;
	private String email;
	private String address;
	private Date startDate;
	private Date terminateDate;
	private String headEmployeeName;
	private String deptName;
	
	@Transient
	private List<EmployeeDetailModel> listTeam;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getTerminateDate() {
		return terminateDate;
	}
	public void setTerminateDate(Date terminateDate) {
		this.terminateDate = terminateDate;
	}
	public List<EmployeeDetailModel> getListTeam() {
		return listTeam;
	}
	public void setListTeam(List<EmployeeDetailModel> listTeam) {
		this.listTeam = listTeam;
	}
	
	public String getHeadEmployeeName() {
		return headEmployeeName;
	}
	public void setHeadEmployeeName(String headEmployeeName) {
		this.headEmployeeName = headEmployeeName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
