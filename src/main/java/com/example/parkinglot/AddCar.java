package com.example.parkinglot;

import com.example.parkinglot.common.UserDto;
import com.example.parkinglot.ejb.CarsBean;
import com.example.parkinglot.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCar", value = "/AddCar")
public class AddCar extends HttpServlet {
    @Inject
    UserBean userBean;

    @Inject
    CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto>users=userBean.findAllUsers();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String licensePlate = request.getParameter("lincense_plate");
        String parkingSpot=request.getParameter("parking_spot");
        Long userId=Long.parseLong(request.getParameter("owner_id"));
        Long carId= Long.parseLong(request.getParameter("car_id"));

        carsBean.createCar(licensePlate,parkingSpot,userId);
        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}