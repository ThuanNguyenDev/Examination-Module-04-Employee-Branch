package com.example.case_study_m4.service.impl;

import com.example.case_study_m4.converter.EmployeeConverter;
import com.example.case_study_m4.dto.request.CreateEmployeeRequestDTO;
import com.example.case_study_m4.dto.response.CommonResponseDTO;
import com.example.case_study_m4.dto.response.EmployeeResponseDTO;
import com.example.case_study_m4.dto.response.PageResponseDTO;
import com.example.case_study_m4.entity.Branch;
import com.example.case_study_m4.entity.Employee;
import com.example.case_study_m4.repo.BranchRepository;
import com.example.case_study_m4.repo.EmployeeRepository;
import com.example.case_study_m4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private  BranchRepository branchRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;
    @Override
    public EmployeeResponseDTO createEmployee(CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        Employee employee = employeeConverter.convertDTOtoEntity(createEmployeeRequestDTO);

        Branch branch = branchRepository.findById(createEmployeeRequestDTO.getBranchId())
                .orElseThrow(() -> new EntityNotFoundException("Branch not found"));

        employee.setBranch(branch);

        employeeRepository.save(employee);

        return employeeConverter.convertEntityToDTO(employee);


    }

    @Override
    public CommonResponseDTO getAllEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        List<EmployeeResponseDTO> productDTOs = employeePage
                .getContent()
                .stream()
                .map(employeeConverter::convertEntityToDTO)
                .collect(Collectors.toList());

        PageResponseDTO<EmployeeResponseDTO> pageResponseDTO = new PageResponseDTO<>();
        pageResponseDTO.setContent(productDTOs);
        pageResponseDTO.setPage(employeePage.getNumber());
        pageResponseDTO.setSize(employeePage.getSize());
        pageResponseDTO.setTotalElements(employeePage.getTotalElements());
        pageResponseDTO.setTotalPages(employeePage.getTotalPages());

        CommonResponseDTO commonResponseDTO = new CommonResponseDTO<>();
        commonResponseDTO.setData(pageResponseDTO);
        commonResponseDTO.setSuccess(true);
        commonResponseDTO.setMessage("Products retrieved successfully.");

        return commonResponseDTO;
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, CreateEmployeeRequestDTO updateEmployeeRequestDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        existingEmployee.setCode(updateEmployeeRequestDTO.getCode());
        existingEmployee.setName(updateEmployeeRequestDTO.getName());
        existingEmployee.setAge(updateEmployeeRequestDTO.getAge());
        existingEmployee.setSalary(updateEmployeeRequestDTO.getSalary());


        Branch branch = branchRepository.findById(updateEmployeeRequestDTO.getBranchId())
                        .orElseThrow(() -> new EntityNotFoundException("Branch not found"));



        existingEmployee.setBranch(branch);

        employeeRepository.save(existingEmployee);

        return employeeConverter.convertEntityToDTO(existingEmployee);


    }

    @Override
    public void deleteEmployee(Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeRepository.delete(existingEmployee);

    }

    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return employeeConverter.convertEntityToDTO(existingEmployee);
    }
}
