package th.example.thailifetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import th.example.thailifetest.models.PositionModel;

@Repository
public interface PositionRepository extends JpaRepository<PositionModel, Long> {
	
	@Query(value = "SELECT *, '' pos_dept_name, null epos_start_date, null epos_end_date, '' epos_status "
			+ "FROM position where pos_dept_id = :deptId ", nativeQuery = true)
	List<PositionModel> findByDept(@Param("deptId") String deptId);
	
	@Query(value = "SELECT pos.*, dp.dept_name pos_dept_name, ep.epos_start_date, ep.epos_end_date, ep.epos_status "
			+ "FROM emp_position ep, position pos , department dp "
			+ "where ep.epos_emp_id = :empId and ep.epos_status = 'Active' and pos.pos_id = ep.epos_pos_id and dp.dept_id = pos.pos_dept_id limit 1 ", nativeQuery = true)
	PositionModel findByEmpId(@Param("empId") String empId);
	
	@Query(value = "SELECT pos.*, dp.dept_name pos_dept_name, ep.epos_start_date, ep.epos_end_date, ep.epos_status "
			+ "FROM emp_position ep, position pos , department dp "
			+ "where ep.epos_emp_id = :empId and pos.pos_id = ep.epos_pos_id and dp.dept_id = pos.pos_dept_id order by ep.epos_status asc, ep.epos_start_date desc", nativeQuery = true)
	List<PositionModel> findAllByEmpId(@Param("empId") String empId);
	
}
