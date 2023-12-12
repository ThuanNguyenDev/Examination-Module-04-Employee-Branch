package com.example.case_study_m4.controller;

import com.example.case_study_m4.dto.request.CreateEmployeeRequestDTO;
import com.example.case_study_m4.dto.response.CommonResponseDTO;
import com.example.case_study_m4.dto.response.EmployeeResponseDTO;
import com.example.case_study_m4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> createEmployee
            (@RequestBody CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        EmployeeResponseDTO newEmployee = employeeService.createEmployee(createEmployeeRequestDTO);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/show")
    public ResponseEntity<CommonResponseDTO<EmployeeResponseDTO>> getEmployee(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "age") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        CommonResponseDTO EmployeePage = employeeService.getAllEmployees(pageable);

        return new ResponseEntity<>(EmployeePage, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @RequestBody CreateEmployeeRequestDTO updateEmployeeRequestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.updateEmployee(id, updateEmployeeRequestDTO);
        return new ResponseEntity<>(employeeResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findVideoById(@PathVariable Long id) {
        EmployeeResponseDTO  foundEmployee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
    }


}
