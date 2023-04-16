package com.UST.collegeinfo.repository;

import com.UST.collegeinfo.entity.CollegeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository<CollegeInfo,Integer> {
    CollegeInfo findBycollegeName(String collegeName);

}
