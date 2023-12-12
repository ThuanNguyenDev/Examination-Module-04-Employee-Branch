package com.example.case_study_m4.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "code")
    private String code;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "age")
    private long age;

    @JoinColumn(name = "salary")
    private long salary;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}


