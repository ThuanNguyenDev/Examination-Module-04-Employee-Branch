package com.example.case_study_m4.dto.response;

import lombok.Data;

@Data
public class CommonResponseDTO<EmployeeResponseDTO> {

    private PageResponseDTO<EmployeeResponseDTO> data;
    private boolean success;
    private String message;
}
