package com.UST.collegeinfo.service;

import com.UST.collegeinfo.entity.CollegeInfo;
import com.UST.collegeinfo.entity.Departments;
import com.UST.collegeinfo.entity.Faculties;
import com.UST.collegeinfo.entity.Hod;
import com.UST.collegeinfo.repository.CollegeRepo;
import com.UST.collegeinfo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CollegeService {

    @Autowired
    public CollegeRepo repo;

    @Autowired
    public DepartmentRepo deptrepo;

    public CollegeInfo addcollege(CollegeInfo collegeinfo) {

        return repo.save(collegeinfo);

    }

    public List<CollegeInfo> getAllCollege() {
        return repo.findAll();
    }

    public CollegeInfo getCollegeById(int id) {
        return repo.findById(id).orElse(null);
    }
    public CollegeInfo getBycollegeName(String collegeName) {
        CollegeInfo collegeinfo =  repo.findBycollegeName(collegeName);
        return new CollegeInfo(collegeinfo.getId(),collegeinfo.getCollegeName());
    }

    public CollegeInfo updateByCollegeId(CollegeInfo college) {
        CollegeInfo info = null;
        Optional<CollegeInfo> optionall = repo.findById(college.getId());
        if(optionall.isPresent()){
            info = optionall.get();
            info.setCollegeName(college.getCollegeName());
            repo.save(info);
        }
        else{
            return new CollegeInfo(college.getId(),college.getCollegeName());
        }
        return info;
    }
    public String deleteCollegeById(int id) {
        repo.deleteById(id);
        return "college deleted...";
    }



    public String addDepttoCollege(int id,Departments dept) {

        Optional<CollegeInfo> collegeOpt = repo.findById(id);
        if(collegeOpt.isPresent()){
            CollegeInfo college = collegeOpt.get();
            List<Departments> department = college.getDepartment();
            dept.setCollegeinfo(college);
            department.add(dept);
            college.setDepartment(department);
            repo.save(college);
            return "Department added successfully....";
        }
        else{
            return "College not found";
        }
    }


    public List<Departments> getDeptBycollegeName(String collegeName) {
        CollegeInfo college = repo.findBycollegeName(collegeName);
        List<Departments> dept = college.getDepartment();
        return dept;
    }

    public String addFacultytoCollege(int id, Faculties faculty) {

        Optional<CollegeInfo> college = repo.findById(id);
        if(college.isPresent()){
            CollegeInfo col = college.get();
            List<Faculties> facultyy = col.getFaculty();
            faculty.setCollege(col);
            facultyy.add(faculty);
            col.setFaculty(facultyy);
            repo.save(col);
            return "Faculty added successfully...";
        }
        else{
            return "College not found";
        }
    }

    public List<Faculties> getFacultyById(int id) {
        CollegeInfo college = repo.findById(id).orElse(null);
        List<Faculties> fac = college.getFaculty();
        return fac;
    }

    public String addFacultyById(int deptId, Faculties faculty) {

        Optional<Departments> department = deptrepo.findById(deptId);
        if(department.isPresent()){
            Departments dept = department.get();
            List<Faculties> fac = dept.getFacultie();
            faculty.setDept(dept);
            fac.add(faculty);
            dept.setFacultie(fac);
            deptrepo.save(dept);
            return "Faculty assigned to department...";
        }
        else{
            return "Department not found";
        }
    }

    public String addHodtoDept(int deptId, Hod hod) {
        Departments dept = deptrepo.findById(deptId).orElse(null);
        dept.setHod(hod);
        deptrepo.save(dept);
        return "HOD assigned to department...";
    }

    public List<Faculties> getFacultyBydepartmentName(String departmentName) {

        Departments dept = deptrepo.findBydepartmentName(departmentName);
        List<Faculties> fac = dept.getFacultie();
        return fac;

    }

    public Hod getHodBydepartmentName(String departmentName) {

        Departments department = deptrepo.findBydepartmentName(departmentName);
        Hod hod = department.getHod();
        return hod;
    }
}
