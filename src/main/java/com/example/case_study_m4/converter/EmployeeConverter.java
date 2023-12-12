package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.request.CreateEmployeeRequestDTO;
import com.example.case_study_m4.dto.response.EmployeeResponseDTO;
import com.example.case_study_m4.entity.Branch;
import com.example.case_study_m4.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee convertDTOtoEntity (CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        Employee employee = new Employee();
            employee.setCode(createEmployeeRequestDTO.getCode());
            employee.setName(createEmployeeRequestDTO.getName());
            employee.setAge(createEmployeeRequestDTO.getAge());
            employee.setSalary(createEmployeeRequestDTO.getSalary());
            Branch branch = new Branch();
            branch.setId(createEmployeeRequestDTO.getBranchId());
            employee.setBranch(branch);
            return employee;
    }


    public EmployeeResponseDTO convertEntityToDTO  (Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(employee.getId());
        employeeResponseDTO.setCode(employee.getCode());
        employeeResponseDTO.setName(employee.getName());
        employeeResponseDTO.setAge(employee.getAge());
        employeeResponseDTO.setSalary(employee.getSalary());
        employeeResponseDTO.setBranchName(employee.getBranch().getName());
        return employeeResponseDTO;
    }


}
