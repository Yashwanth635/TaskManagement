package com.example.TaskManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Taskid;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @NotBlank
    private String name;

    @NotBlank
    private String subject;

    @NotBlank
    private String title;

    @NotNull
    private LocalDate fromDate;

    @NotNull
    private LocalDate toDate;

    @Pattern(regexp = "^(pending|completed)$", message = "Status should be 'pending' or 'completed'")
    private String status;


    public Long getTaskid() {
        return Taskid;
    }

    public void setTaskid(Long taskid) {
        Taskid = taskid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + Taskid +
                ", student=" + student +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", status='" + status + '\'' +
                '}';
    }
}
