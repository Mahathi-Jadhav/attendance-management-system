package com.university.controller;

import com.university.model.AttendanceDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AttendanceController extends HttpServlet {
    private AttendanceDao attendanceDao;

    @Override
    public void init() throws ServletException {
        attendanceDao = new AttendanceDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        request.setAttribute("attendanceList", attendanceDao.getAttendanceForCourse(courseId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/attendance.jsp");
        dispatcher.forward(request, response);
    }
}
