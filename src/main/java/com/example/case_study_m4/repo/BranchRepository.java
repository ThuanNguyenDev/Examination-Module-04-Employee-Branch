package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends CrudRepository<Branch,Long> {
}
