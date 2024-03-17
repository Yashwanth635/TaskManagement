package com.example.TaskManagement.service;

import com.example.TaskManagement.entity.Student;
import com.example.TaskManagement.entity.Task;

import java.util.List;

public interface TaskService {
    Task addTaskService(Task task);
    List<Task> getTasksByStudentId(long studentId);
    Task updateTaskStatus(long taskid, String newStatus);
    boolean deleteTask(long taskid);
}
