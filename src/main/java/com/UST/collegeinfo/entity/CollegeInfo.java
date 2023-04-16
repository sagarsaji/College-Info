package com.UST.collegeinfo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "college_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CollegeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "college_name")
    private String collegeName;

    @OneToMany(mappedBy = "collegeinfo",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Departments> department;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Faculties> faculty;
    public CollegeInfo(int id, String collegeName) {
    }


}
