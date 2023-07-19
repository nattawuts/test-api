package th.example.thailifetest.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "position")
public class PositionModel {
	@Id
	private String posId;
	private String posDeptId;
	private String posDeptName;
	private Date eposStartDate;
	private Date eposEndDate;
	private String posName;
	private Date posCreateDate;
	private Date posUpdateDate;
	private String eposStatus;
	
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	public String getPosDeptId() {
		return posDeptId;
	}
	public void setPosDeptId(String posDeptId) {
		this.posDeptId = posDeptId;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public Date getPosCreateDate() {
		return posCreateDate;
	}
	public void setPosCreateDate(Date posCreateDate) {
		this.posCreateDate = posCreateDate;
	}
	public Date getPosUpdateDate() {
		return posUpdateDate;
	}
	public void setPosUpdateDate(Date posUpdateDate) {
		this.posUpdateDate = posUpdateDate;
	}
	public String getPosDeptName() {
		return posDeptName;
	}
	public void setPosDeptName(String posDeptName) {
		this.posDeptName = posDeptName;
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
	public String getEposStatus() {
		return eposStatus;
	}
	public void setEposStatus(String eposStatus) {
		this.eposStatus = eposStatus;
	}
	
	
}
