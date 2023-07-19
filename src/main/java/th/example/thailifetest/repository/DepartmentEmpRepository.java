package th.example.thailifetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.example.thailifetest.models.DepartmentEmployeeModel;

@Repository
public interface DepartmentEmpRepository  extends JpaRepository<DepartmentEmployeeModel, Long>{

	@Query(value = "select dept.dept_id, dept.dept_name, ed.employee_name "
			+ "from department dept, deparement_head dh , employee_detail ed "
			+ "where dept.dept_id = dh.department_id and dept.dept_org_code is null "
			+ "and ed.employee_id = dh.employee_id", nativeQuery = true)
	DepartmentEmployeeModel searchDeptMaster();
	
	@Query(value = "select dept.dept_id, dept.dept_name, ed.employee_name  "
			+ "from department dept, deparement_head dh, employee_detail ed "
			+ "where dept.dept_id = dh.department_id and dept.dept_org_code = :orgCode "
			+ "and ed.employee_id = dh.employee_id", nativeQuery = true)
	List<DepartmentEmployeeModel> searchListDeptWithOrgCode(@Param("orgCode") String orgCode);
}
