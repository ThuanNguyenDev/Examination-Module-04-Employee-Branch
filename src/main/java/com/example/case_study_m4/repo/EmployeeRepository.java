package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>, PagingAndSortingRepository <Employee,Long>{
}
