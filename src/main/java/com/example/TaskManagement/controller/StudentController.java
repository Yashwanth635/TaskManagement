package com.example.TaskManagement.controller;

import com.example.TaskManagement.entity.Student;
import com.example.TaskManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stud")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudentController(@RequestBody Student student) {
        studentService.addstudentService(student);
        return student;
    }
    @PutMapping("/updatePhoneNumber/{studentId}")
    public ResponseEntity<String> updateStudentPhoneNumber(@PathVariable int studentId, @RequestParam long newPhoneNumber) {
        try {
            studentService.updateStudentPhone(studentId, newPhoneNumber);
            return ResponseEntity.ok("Phone number updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with id: " + studentId);
        }
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Student> getAllStudents(@PathVariable int offset,@PathVariable int pageSize)
    {
        Page<Student> students = studentService.getAllStudent(offset, pageSize);
        return students;
    }
}
