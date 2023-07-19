package th.example.thailifetest.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "employee")
public class EmployeeModel {
	@Id
	private String empId;
	private String empName;
	private String empLastname;
	private String empBirthday;
	private String empStatus;
	private String empIdcard;
	private String empImage;
	private Date empCreateDate;
	private Date empUpdateDate;
	private String empMobileNo;
	private String empEmail;
	private String empAddress;
	
	@Transient
	private String posDeptId;
	@Transient
	private String posDeptName;
	@Transient
	private String posName;
	@Transient
	private String posStartDate;
	@Transient
	private String posEndDate;
	@Transient
	private String posId;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpLastname() {
		return empLastname;
	}
	public void setEmpLastname(String empLastname) {
		this.empLastname = empLastname;
	}
	public String getEmpBirthday() {
		return empBirthday;
	}
	public void setEmpBirthday(String empBirthday) {
		this.empBirthday = empBirthday;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpIdcard() {
		return empIdcard;
	}
	public void setEmpIdcard(String empIdcard) {
		this.empIdcard = empIdcard;
	}
	public String getEmpImage() {
		return empImage;
	}
	public void setEmpImage(String empImage) {
		this.empImage = empImage;
	}
	public Date getEmpCreateDate() {
		return empCreateDate;
	}
	public void setEmpCreateDate(Date empCreateDate) {
		this.empCreateDate = empCreateDate;
	}
	public Date getEmpUpdateDate() {
		return empUpdateDate;
	}
	public void setEmpUpdateDate(Date empUpdateDate) {
		this.empUpdateDate = empUpdateDate;
	}
	public String getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(String empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getPosDeptId() {
		return posDeptId;
	}
	public void setPosDeptId(String posDeptId) {
		this.posDeptId = posDeptId;
	}
	public String getPosDeptName() {
		return posDeptName;
	}
	public void setPosDeptName(String posDeptName) {
		this.posDeptName = posDeptName;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getPosStartDate() {
		return posStartDate;
	}
	public void setPosStartDate(String posStartDate) {
		this.posStartDate = posStartDate;
	}
	public String getPosEndDate() {
		return posEndDate;
	}
	public void setPosEndDate(String posEndDate) {
		this.posEndDate = posEndDate;
	}
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	
	
}
