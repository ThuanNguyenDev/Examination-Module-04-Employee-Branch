package com.example.case_study_m4.dto.response;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
    private long id;
    private String code;
    private String name;
    private long age;
    private long salary;
    private String branchName;

}
