package th.example.thailifetest.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.example.thailifetest.iservice.IProfileService;
import th.example.thailifetest.models.DepartmentEmployeeModel;
import th.example.thailifetest.models.DepartmentModel;
import th.example.thailifetest.models.EmployeeDetailModel;
import th.example.thailifetest.models.EmployeeModel;
import th.example.thailifetest.models.EmployeePositionModel;
import th.example.thailifetest.models.PositionModel;
import th.example.thailifetest.repository.DepartmentEmpRepository;
import th.example.thailifetest.repository.DepartmentRepository;
import th.example.thailifetest.repository.EmployeeDetailRepository;
import th.example.thailifetest.repository.EmployeePositionRepository;
import th.example.thailifetest.repository.EmployeeRepository;
import th.example.thailifetest.repository.PositionRepository;
import th.example.thailifetest.request.NewEmployeeRequest;

@Service
public class ProfileService  implements IProfileService{


	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeDetailRepository employeeDetailRepository;
	
	@Autowired
	private DepartmentEmpRepository departmentEmpRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private EmployeePositionRepository employeePositionRepository;
	
	@Override
	public List<EmployeeModel> searchAllEmployee() {
		List<EmployeeModel> empM = employeeRepository.findAll();
		getPosData(empM);
		return empM;
	}

	@Override
	public List<EmployeeModel> searchEmployeeByName(String empName, String lastName) {
		List<EmployeeModel> empM = employeeRepository.findByName(empName, lastName);
		getPosData(empM);
		return empM;
	}
	
	private void getPosData(List<EmployeeModel> empM ) {
		if(empM != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			for(EmployeeModel emp : empM) {
				PositionModel pos = positionRepository.findByEmpId(emp.getEmpId());
				if(pos != null) {
					emp.setPosId(pos.getPosId());
					emp.setPosDeptName(pos.getPosDeptName());
					emp.setPosDeptId(pos.getPosDeptId());
					emp.setPosName(pos.getPosName());
					if(pos.getEposEndDate() != null) {
						emp.setPosEndDate(dateFormat.format(pos.getEposEndDate()));
					}
					emp.setPosStartDate(dateFormat.format(pos.getEposStartDate()));
				}
			}
		}
	}
	
	@Override
	public List<EmployeeDetailModel> searchEmployeeByDept(String deptId) {
		if(deptId == null || deptId.length() ==0) {
			return null;
		}
		return employeeDetailRepository.searchEmployeeByDept(deptId);
	}

	@Override
	public EmployeeDetailModel searchEmployeeById(String empId) {
		if(empId == null || empId.length() ==0) {
			return null;
		}
		EmployeeDetailModel resp = employeeDetailRepository.searchEmployeeById(empId);
		if(resp != null ) {
			resp.setListTeam(employeeDetailRepository.searchTeamByEmpId(empId));
		}
		return resp;
	}

	@Override
	public DepartmentEmployeeModel searchDeptHir() {
		DepartmentEmployeeModel masterDept = departmentEmpRepository.searchDeptMaster();
		if(masterDept != null) {
			List<DepartmentEmployeeModel> listEmpt = departmentEmpRepository.searchListDeptWithOrgCode(masterDept.getDeptId());
			masterDept.setListTeam(getDeptHir(listEmpt));
			;
		}
		return masterDept;
	}
	
	private List<DepartmentEmployeeModel> getDeptHir(List<DepartmentEmployeeModel> listEmpt) {
		if(listEmpt != null) {
			for(DepartmentEmployeeModel emp : listEmpt) {
				List<DepartmentEmployeeModel> newListEmpt = departmentEmpRepository.searchListDeptWithOrgCode(emp.getDeptId());
				if(newListEmpt != null && newListEmpt.size() > 0) {
					emp.setListTeam(getDeptHir(newListEmpt));
				}
			}
		}
		return listEmpt;
	}

	@Override
	public void newEmployee(NewEmployeeRequest empReq) {
		EmployeeModel emp = new EmployeeModel();
		java.util.Date date = new java.util.Date();
		String empId = genId("E",date);
		
		emp.setEmpAddress(empReq.getEmpAddress());
		emp.setEmpBirthday(empReq.getEmpBirthday());
		emp.setEmpCreateDate(new Date(date.getTime()));
		emp.setEmpEmail(empReq.getEmpEmail());
		emp.setEmpId(empId);
		emp.setEmpIdcard(empReq.getEmpIdcard());
		emp.setEmpImage(empReq.getEmpImage());
		emp.setEmpLastname(empReq.getEmpLastname());
		emp.setEmpMobileNo(empReq.getEmpMobileNo());
		emp.setEmpName(empReq.getEmpName());
		emp.setEmpStatus("Active");
		emp.setEmpUpdateDate(new Date(date.getTime()));
		employeeRepository.insertEmployee(emp);
		
		String empEPosId = genId("T",date);
		EmployeePositionModel empPos = new EmployeePositionModel();
		empPos.setEposCreateDate(new Date(date.getTime()));
		empPos.setEposEmpId(empId);
//		empPos.setEposEndDate(empReq.getEposEndDate());
		empPos.setEposId(empEPosId);
		empPos.setEposPosId(empReq.getEposPosId());
		empPos.setEposStartDate(new Date(date.getTime()));
		empPos.setEposStatus("Active");
		empPos.setEposUpdateDate(new Date(date.getTime()));
		employeePositionRepository.insertEmpPos(empPos);
	}
	
	@Override
	public void saveEmployee(NewEmployeeRequest empReq) {
		EmployeeModel emp = new EmployeeModel();
		java.util.Date date = new java.util.Date();
		
		emp.setEmpAddress(empReq.getEmpAddress());
		emp.setEmpBirthday(empReq.getEmpBirthday());
		emp.setEmpCreateDate(new Date(date.getTime()));
		emp.setEmpEmail(empReq.getEmpEmail());
		emp.setEmpId(empReq.getEmpId());
		emp.setEmpIdcard(empReq.getEmpIdcard());
		emp.setEmpImage(empReq.getEmpImage());
		emp.setEmpLastname(empReq.getEmpLastname());
		emp.setEmpMobileNo(empReq.getEmpMobileNo());
		emp.setEmpName(empReq.getEmpName());
		emp.setEmpStatus(empReq.getEmpStatus());
		emp.setEmpUpdateDate(new Date(date.getTime()));
		employeeRepository.updateEmployee(emp);
		
		if( "Inactive".equals(empReq.getEmpStatus())) {
			employeePositionRepository.inactiveEmpPos(empReq.getEmpId());
		}else if( !empReq.getEposPosIdOld().equals(empReq.getEposPosId())) {
			System.out.println(empReq.getEposPosIdOld());
			System.out.println(empReq.getEposPosId());
			String empEPosId = genId("T",date);
			EmployeePositionModel empPos = new EmployeePositionModel();
			empPos.setEposCreateDate(new Date(date.getTime()));
			empPos.setEposEmpId(empReq.getEmpId());
			empPos.setEposId(empEPosId);
			empPos.setEposPosId(empReq.getEposPosId());
			empPos.setEposStartDate(new Date(date.getTime()));
			empPos.setEposStatus("Active");
			empPos.setEposUpdateDate(new Date(date.getTime()));
			employeePositionRepository.inactiveEmpPos(empReq.getEmpId());
			employeePositionRepository.insertEmpPos(empPos);
		}
	}

	@Override
	public List<DepartmentModel> getDepartmentAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<PositionModel>  getPositionByDept(String deptId) {
		return positionRepository.findByDept(deptId);
	}

	private String genId(String prefix,  java.util.Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYMMddSSS");
		return prefix + dateFormat.format(date);
	}

	@Override
	public List<PositionModel> getAllPositionByEmpId(String empId) {
		return positionRepository.findAllByEmpId(empId);
	}


}
