package com.UST.collegeinfo.controller;

import com.UST.collegeinfo.entity.CollegeInfo;
import com.UST.collegeinfo.entity.Departments;
import com.UST.collegeinfo.entity.Faculties;
import com.UST.collegeinfo.entity.Hod;
import com.UST.collegeinfo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    public CollegeService collegeservice;

    @PostMapping("/add")
    public CollegeInfo addCollege(@RequestBody CollegeInfo collegeinfo){
        return collegeservice.addcollege(collegeinfo);
    }

    @GetMapping("/colleges")
    public List<CollegeInfo> getCollege(){
        return collegeservice.getAllCollege();
    }

    @GetMapping("/{id}")
    public CollegeInfo getCollegeById(@PathVariable int id){
        return collegeservice.getCollegeById(id);
    }

    @GetMapping("/find/{collegeName}")
    public CollegeInfo getBycollegeName(@PathVariable String collegeName){
        return collegeservice.getBycollegeName(collegeName);
    }

    @PutMapping("/{id}")
    public CollegeInfo updateCollegeById(@RequestBody CollegeInfo college){
        return collegeservice.updateByCollegeId(college);
    }

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable int id){
        return collegeservice.deleteCollegeById(id);
    }


    @PostMapping("/department/{id}")
    public String addDepttoClg(@PathVariable int id,@RequestBody Departments dept){
        return collegeservice.addDepttoCollege(id,dept);
    }

    @GetMapping("/department/{collegeName}")
    public List<Departments> getDeptBycollegeName(@PathVariable String collegeName){
        return collegeservice.getDeptBycollegeName(collegeName);
    }

    @PostMapping("/faculties/{id}")
    public String addFacultiestoClg(@PathVariable int id, @RequestBody Faculties faculty){
        return collegeservice.addFacultytoCollege(id,faculty);
    }

    @GetMapping("/faculties/{id}")
    public List<Faculties> getFacultyById(@PathVariable int id){
        return collegeservice.getFacultyById(id);
    }

    @PostMapping("/faculty/{deptId}")
    public String addFacultiestoDept(@PathVariable int deptId, @RequestBody Faculties faculty){
        return collegeservice.addFacultyById(deptId,faculty);
    }

    @PostMapping("/hod/{deptId}")
    public String addHodtoDept(@PathVariable int deptId, @RequestBody Hod hod){
        return collegeservice.addHodtoDept(deptId,hod);
    }

    @GetMapping("/getfaculties/{departmentName}")
    public List<Faculties> getFacultiesBydepartmentName(@PathVariable String departmentName){
        return collegeservice.getFacultyBydepartmentName(departmentName);
    }

    @GetMapping("/gethod/{departmentName}")
    public Hod getHodBydepartmentName(@PathVariable String departmentName){
        return collegeservice.getHodBydepartmentName(departmentName);
    }

}
