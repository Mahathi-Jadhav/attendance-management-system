package com.university.service;

import com.university.model.Student;
import com.university.model.StudentDao;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }
}
