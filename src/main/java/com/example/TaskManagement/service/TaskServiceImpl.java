package com.example.TaskManagement.service;

import com.example.TaskManagement.entity.Student;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task addTaskService(Task task) {
        taskRepository.save(task);
        return task;
    }

    public List<Task> getTasksByStudentId(long studentId) {
        return taskRepository.findByStudentStudentId(studentId);
    }

    public Task updateTaskStatus(long taskid, String newStatus) {
        Optional<Task> optionalTask = taskRepository.findById(taskid);
        System.out.println(optionalTask);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(newStatus);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Student not found with id: " + taskid);
        }
    }

    public boolean deleteTask(long taskId) {
        try {
            taskRepository.deleteById(taskId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}