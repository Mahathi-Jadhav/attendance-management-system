package com.university.service;

import com.university.model.Attendance;
import com.university.model.AttendanceDao;

import java.sql.Date;
import java.util.List;

public class AttendanceService {
    private AttendanceDao attendanceDao;

    public AttendanceService() {
        attendanceDao = new AttendanceDao();
    }

    public boolean recordAttendance(int studentId, int courseId, Date attendanceDate, String status) {
        return attendanceDao.recordAttendance(studentId, courseId, attendanceDate, status);
    }

    public List<Attendance> getAttendanceForCourse(int courseId) {
        return attendanceDao.getAttendanceForCourse(courseId);
    }

    public Attendance getAttendanceByStudentAndCourse(int studentId, int courseId, Date attendanceDate) {
        return attendanceDao.getAttendanceByStudentAndCourse(studentId, courseId, attendanceDate);
    }
}
