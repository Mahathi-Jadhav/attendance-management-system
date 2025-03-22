package com.university.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.university.model.util.DatabaseConnection;

public class AttendanceDao {
    private Connection connection;

    public AttendanceDao() {
        connection = DatabaseConnection.getConnection();
    }

    public boolean recordAttendance(int studentId, int courseId, Date attendanceDate, String status) {
        String query = "INSERT INTO attendance (student_id, course_id, attendance_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setDate(3, attendanceDate);
            stmt.setString(4, status);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Attendance> getAttendanceForCourse(int courseId) {
        List<Attendance> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM attendance WHERE course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setCourseId(rs.getInt("course_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setStatus(rs.getString("status"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    public Attendance getAttendanceByStudentAndCourse(int studentId, int courseId, Date attendanceDate) {
        String query = "SELECT * FROM attendance WHERE student_id = ? AND course_id = ? AND attendance_date = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.setDate(3, attendanceDate);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setStudentId(rs.getInt("student_id"));
                attendance.setCourseId(rs.getInt("course_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setStatus(rs.getString("status"));
                return attendance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
