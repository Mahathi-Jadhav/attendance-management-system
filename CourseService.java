package com.university.service;

import com.university.model.Course;
import com.university.model.CourseDao;

import java.util.List;

public class CourseService {
    private CourseDao courseDao;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public boolean addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
}
