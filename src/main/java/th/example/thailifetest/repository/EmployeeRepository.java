package th.example.thailifetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.example.thailifetest.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
	@Query(value = "SELECT e.* "
			+ "FROM employee e  ", nativeQuery = true)
	List<EmployeeModel> findAll();
	
	@Query(value = "SELECT e.* "
			+ "FROM employee e   "
			+ "where ( "
			+ "case when :empName is null or :empName = '' then 'N'  "
			+ "when  emp_name like '%'||:empName||'%' then 'Y' else 'N'  end = 'Y' "
			+ "or "
			+ "case when :empLastname is null or :empLastname = '' then 'N'  "
			+ "when  emp_lastname like '%'||:empLastname||'%' then 'Y' else 'N'  end = 'Y')", nativeQuery = true)
	List<EmployeeModel> findByName( @Param("empName") String empName, @Param("empLastname") String empLastname);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO employee( "
			+ "	emp_id, emp_name, emp_lastname, emp_birthday, emp_status, emp_idcard, emp_create_date, emp_update_date, emp_image, emp_mobile_no,emp_email,emp_address) "
			+ "	VALUES (:#{#emp.empId}, :#{#emp.empName}, :#{#emp.empLastname}, :#{#emp.empBirthday}, :#{#emp.empStatus}, "
			+ " :#{#emp.empIdcard}, :#{#emp.empCreateDate}, :#{#emp.empUpdateDate}, :#{#emp.empImage}, :#{#emp.empMobileNo}, :#{#emp.empEmail}, :#{#emp.empAddress})", nativeQuery = true)
	public abstract void insertEmployee(@Param("emp") EmployeeModel emp);
	
	@Modifying
	@Transactional
	@Query(value = "update employee set "
			+ "	emp_name = :#{#emp.empName}, emp_lastname = :#{#emp.empLastname}, emp_birthday =:#{#emp.empBirthday} "
			+ ", emp_status = :#{#emp.empStatus}, emp_idcard = :#{#emp.empIdcard}, emp_update_date = :#{#emp.empUpdateDate}, "
			+ "emp_image = :#{#emp.empImage}, emp_mobile_no = :#{#emp.empMobileNo}, emp_email = :#{#emp.empEmail}, emp_address = :#{#emp.empAddress}  "
			+ " where emp_id = :#{#emp.empId} ", nativeQuery = true)
	public abstract void updateEmployee(@Param("emp") EmployeeModel emp);
}

