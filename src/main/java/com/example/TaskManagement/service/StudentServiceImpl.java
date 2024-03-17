package com.example.TaskManagement.service;

import com.example.TaskManagement.entity.Student;
import com.example.TaskManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    public Student addstudentService(Student student){
        studentRepository.save(student);
        return student;
    }

    public Student updateStudentPhone(int studentId, long newPhoneNumber) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        System.out.println(optionalStudent);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setPhoneNo(newPhoneNumber);
            return studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
    }

    @Override
    public Page<Student> getAllStudent(int offset, int pageSize) {
        Page<Student> students = studentRepository.findAll(PageRequest.of(offset,pageSize));
        return students;
    }
}
