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
@Table(name = "hod_table")

public class Hod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "h_id")
    private int hid;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "hod",cascade = CascadeType.ALL)
    @JsonIgnore
    private Departments dept;

}
