package com.example.parkinglot;

import com.example.parkinglot.common.CarDto;
import com.example.parkinglot.common.UserDto;
import com.example.parkinglot.ejb.CarsBean;
import com.example.parkinglot.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed =
        {"WRITE_CARS"}))
@WebServlet(name = "EditCar", value = "/EditCar")
public class EditCar extends HttpServlet {
    @Inject
    UserBean userBean;

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users",users);

        Long carId=Long.parseLong(request.getParameter("id"));
        CarDto car=carsBean.findById(carId);
        request.setAttribute("car",car);
        request.getRequestDispatcher("/WEB-INF/pages/editCar.jpg").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
    }
}