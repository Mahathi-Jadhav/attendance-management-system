package com.university.model;

import java.sql.Date;

public class Attendance {
    private int attendanceId;
    private int studentId;
    private int courseId;
    private Date attendanceDate;
    private String status; // e.g., "Present", "Absent"

    // Getter and Setter for attendanceId
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    // Getter and Setter for studentId
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for courseId
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Getter and Setter for attendanceDate
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
