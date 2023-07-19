package th.example.thailifetest.iservice;

import java.util.List;

import th.example.thailifetest.models.DepartmentEmployeeModel;
import th.example.thailifetest.models.DepartmentModel;
import th.example.thailifetest.models.EmployeeDetailModel;
import th.example.thailifetest.models.EmployeeModel;
import th.example.thailifetest.models.PositionModel;
import th.example.thailifetest.request.NewEmployeeRequest;

public interface IProfileService {
	public List<EmployeeModel> searchAllEmployee();
	public List<EmployeeModel> searchEmployeeByName(String empName, String lastName);
	public List<EmployeeDetailModel> searchEmployeeByDept(String deptId);
	public EmployeeDetailModel searchEmployeeById(String empId);
	public DepartmentEmployeeModel searchDeptHir();
	public void newEmployee(NewEmployeeRequest empReq);
	public void saveEmployee(NewEmployeeRequest empReq);
	public List<DepartmentModel> getDepartmentAll();
	public List<PositionModel> getPositionByDept(String deptId);
	public List<PositionModel> getAllPositionByEmpId(String deptId);
}
