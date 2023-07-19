package th.example.thailifetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.example.thailifetest.models.EmployeePositionModel;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePositionModel, Long>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO emp_position( "
			+ "	epos_id, epos_emp_id, epos_pos_id, epos_status, epos_start_date, epos_end_date, epos_create_date, epos_update_date) "
			+ "	VALUES (:#{#empPos.eposId}, :#{#empPos.eposEmpId}, :#{#empPos.eposPosId}, :#{#empPos.eposStatus} "
			+ ", :#{#empPos.eposStartDate} , :#{#empPos.eposEndDate}, :#{#empPos.eposCreateDate}, :#{#empPos.eposUpdateDate})", nativeQuery = true)
	void insertEmpPos(@Param("empPos") EmployeePositionModel empPos);
	
	@Modifying
	@Transactional
	@Query(value = "update emp_position set "
			+ "epos_status = 'Inactive',  epos_end_date = now(), epos_update_date = now() "
			+ "where epos_emp_id = :empId", nativeQuery = true)
	void inactiveEmpPos(@Param("empId") String empId);
	
}
