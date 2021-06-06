package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.fms.entities.Employee;

public interface ITrainerManagementRepository extends JpaRepository<Employee,Integer> {

	@Query("select e.password from Employee e where e.employeeId=:employeeId")
	public String getPassword(@Param("employeeId") int userId);
}
