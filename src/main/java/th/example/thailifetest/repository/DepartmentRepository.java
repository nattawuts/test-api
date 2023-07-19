package th.example.thailifetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import th.example.thailifetest.models.DepartmentModel;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long>{
	@Query(value = "SELECT * "
			+ "FROM department  ", nativeQuery = true)
	List<DepartmentModel> findAll();
	

}
