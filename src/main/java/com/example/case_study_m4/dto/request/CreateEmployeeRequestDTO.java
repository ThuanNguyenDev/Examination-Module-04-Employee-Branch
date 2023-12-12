package com.example.case_study_m4.dto.request;

import lombok.Data;

@Data
public class CreateEmployeeRequestDTO {
    private String code;
    private String name;
    private long age;
    private long salary;
    private long branchId;
}
