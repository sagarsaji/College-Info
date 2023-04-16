package com.UST.collegeinfo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "faculty_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fId")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fId")
    @JsonProperty("fId")
    private int fId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id",referencedColumnName = "id")
    @JsonIgnore
    private CollegeInfo college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "dept_id")
    @JsonIgnore
    private Departments dept;

}
