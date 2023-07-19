package th.example.thailifetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.example.thailifetest.models.EmployeeDetailModel;

@Repository
public interface EmployeeDetailRepository  extends JpaRepository<EmployeeDetailModel, Long>{

	@Query(value = "select  ed.*, ed2.employee_name head_employee_name, dept.dept_name "
			+ "from department_detail dd, employee_detail ed, deparement_head dh, employee_detail ed2, department dept "
			+ "where dd.department_id = :deptId and ed.employee_id = dd.employee_id "
			+ "and ed.terminate_date is null "
			+ "and dh.department_id = dd.department_id "
			+ "and ed2.employee_id = dh.employee_id "
			+ "and dept.dept_id = dd.department_id", nativeQuery = true)
	List<EmployeeDetailModel> searchEmployeeByDept(@Param("deptId") String deptId);

	@Query(value = "select ed.*, ed2.employee_name head_employee_name,  dept.dept_name "
			+ "from employee_detail ed, department_detail  dd, department dept, deparement_head dh, employee_detail ed2 "
			+ "where ed.employee_id = :empId "
			+ "and dd.employee_id = ed.employee_id "
			+ "and dept.dept_id = dd.department_id "
			+ "and dh.department_id = dept.dept_id "
			+ "and ed2.employee_id = dh.employee_id", nativeQuery = true)
	EmployeeDetailModel searchEmployeeById(@Param("empId") String empId);
	
	@Query(value = "select ed.*, '' head_employee_name,  '' dept_name from deparement_head dh, department_detail dd, employee_detail ed where dh.employee_id = :empId and  dd.department_id = dh.department_id and ed.employee_id = dd.employee_id and dh.employee_id <> dd.employee_id ", nativeQuery = true)
	List<EmployeeDetailModel> searchTeamByEmpId(@Param("empId") String empId);
}
