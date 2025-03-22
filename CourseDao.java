package com.university.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.university.model.util.DatabaseConnection;

public class CourseDao {
    private Connection connection;

    public CourseDao() {
        connection = DatabaseConnection.getConnection();
    }

    public boolean addCourse(Course course) {
        String query = "INSERT INTO courses (course_name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
