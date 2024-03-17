package com.example.TaskManagement.repository;

import com.example.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStudentStudentId(long studentId);
}






























//{
//        "student": {
//        "studentId": 1
//        },
//        "name": "John Doe",
//        "subject": "physics",
//        "title": "Solve Equations",
//        "fromDate": "2024-03-15",
//        "toDate": "2024-03-20",
//        "status": "pending"
//        }