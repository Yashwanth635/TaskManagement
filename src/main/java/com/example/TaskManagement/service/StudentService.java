package com.example.TaskManagement.service;

import com.example.TaskManagement.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Student addstudentService(Student student);
    Student updateStudentPhone(int studentId, long newPhoneNumber);
    Page<Student> getAllStudent(int offset, int pageSize);
}

