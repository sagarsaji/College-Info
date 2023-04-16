package com.UST.collegeinfo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "department_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deptId")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    @JsonProperty("deptId")
    private int deptId;
    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id",referencedColumnName = "id")
    @JsonIgnore
    private CollegeInfo collegeinfo;

    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Faculties> facultie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hod_id",referencedColumnName = "h_id")
    private Hod hod;

    public Departments(int deptId, String departmentName) {
    }
}
