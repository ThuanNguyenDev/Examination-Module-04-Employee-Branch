package com.example.case_study_m4.service;

import com.example.case_study_m4.dto.request.CreateEmployeeRequestDTO;
import com.example.case_study_m4.dto.response.CommonResponseDTO;
import com.example.case_study_m4.dto.response.EmployeeResponseDTO;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(CreateEmployeeRequestDTO createEmployeeRequestDTO);

    CommonResponseDTO getAllEmployees(Pageable pageable);

    EmployeeResponseDTO updateEmployee(Long id, CreateEmployeeRequestDTO updateEmployeeRequestDTO);

    void deleteEmployee(Long id);

    EmployeeResponseDTO findEmployeeById(Long id);
}
