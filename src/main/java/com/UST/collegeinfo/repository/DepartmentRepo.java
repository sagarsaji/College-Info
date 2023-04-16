package com.UST.collegeinfo.repository;

import com.UST.collegeinfo.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments,Integer> {

    Departments findBydepartmentName(String departmentName);
}
