package com.beast.studentmangementapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beast.studentmangementapi.entity.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

}
