package com.example.TaskManagement.controller;

import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/addTask")
    public Task addTaskController(@RequestBody Task task)
    {
        return taskService.addTaskService(task);
    }

    @GetMapping("/byStudentId/{studentId}")
    public ResponseEntity<List<Task>> getTasksByStudentId(@PathVariable long studentId) {
        List<Task> tasks = taskService.getTasksByStudentId(studentId);
        if (tasks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tasks);
        } else {
            return ResponseEntity.ok(tasks);
        }
    }
    @PutMapping("/updateStatus/{taskid}")
    public ResponseEntity<String> updateStudentPhoneNumber(@PathVariable long taskid, @RequestParam String newStatus) {
        try {
            taskService.updateTaskStatus(taskid, newStatus);
            return ResponseEntity.ok("Status updated successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("task not found with id: " + taskid);
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable long taskId) {
        boolean deleted = taskService.deleteTask(taskId);
        if (deleted) {
            return ResponseEntity.ok("Task deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found with id: " + taskId);
        }
    }

}
