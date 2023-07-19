package th.example.thailifetest.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "emp_position")
public class EmployeePositionModel {

	@Id
	private String eposId;
	private String eposEmpId;
	private String eposPosId;
	private String eposStatus;
	private Date eposStartDate;
	private Date eposEndDate;
	private Date eposCreateDate;
	private Date eposUpdateDate;
	
	public String getEposId() {
		return eposId;
	}
	public void setEposId(String eposId) {
		this.eposId = eposId;
	}
	public String getEposEmpId() {
		return eposEmpId;
	}
	public void setEposEmpId(String eposEmpId) {
		this.eposEmpId = eposEmpId;
	}
	public String getEposPosId() {
		return eposPosId;
	}
	public void setEposPosId(String eposPosId) {
		this.eposPosId = eposPosId;
	}
	public String getEposStatus() {
		return eposStatus;
	}
	public void setEposStatus(String eposStatus) {
		this.eposStatus = eposStatus;
	}
	public Date getEposStartDate() {
		return eposStartDate;
	}
	public void setEposStartDate(Date eposStartDate) {
		this.eposStartDate = eposStartDate;
	}
	public Date getEposEndDate() {
		return eposEndDate;
	}
	public void setEposEndDate(Date eposEndDate) {
		this.eposEndDate = eposEndDate;
	}
	public Date getEposCreateDate() {
		return eposCreateDate;
	}
	public void setEposCreateDate(Date eposCreateDate) {
		this.eposCreateDate = eposCreateDate;
	}
	public Date getEposUpdateDate() {
		return eposUpdateDate;
	}
	public void setEposUpdateDate(Date eposUpdateDate) {
		this.eposUpdateDate = eposUpdateDate;
	}
	
}
