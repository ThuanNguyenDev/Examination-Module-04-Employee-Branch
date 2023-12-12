package com.example.case_study_m4.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="branch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "name")
    private String name;

    @OneToMany(mappedBy = "branch",fetch = FetchType.LAZY)
    private List<Employee> employees;

}
