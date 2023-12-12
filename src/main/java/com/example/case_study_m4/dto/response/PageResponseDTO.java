package com.example.case_study_m4.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO<EmployeeResponseDTO> {
    private List<EmployeeResponseDTO> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
