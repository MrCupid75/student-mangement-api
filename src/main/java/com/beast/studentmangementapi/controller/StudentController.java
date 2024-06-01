package com.beast.studentmangementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beast.studentmangementapi.entity.StudentModel;
import com.beast.studentmangementapi.respository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<StudentModel> getAllStudents() {

        List<StudentModel> studentList = studentRepository.findAll();

        return studentList;
    }

    @GetMapping("/students/{id}")
    public StudentModel getAStudent(@PathVariable int id) {

        StudentModel aStudent = studentRepository.findById(id).get();

        return aStudent;
    }

    @PostMapping("/students/add")
    public void createStudent(@RequestBody StudentModel student) {
        studentRepository.save(student);
    }

    @PutMapping("/students/update/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable int id, @RequestBody StudentModel studentModel) {
        
        StudentModel updateStudent = studentRepository.findById(id).get();

        updateStudent.setName(studentModel.getName());
        updateStudent.setBranch(studentModel.getBranch());
        updateStudent.setPercentage(studentModel.getPercentage());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/students/delete/{id}")
    public List<StudentModel> deleteStudent(@PathVariable int id) {
        studentRepository.deleteById(id);

        List<StudentModel> allStudent = studentRepository.findAll(); 

        return allStudent;
    }
}
