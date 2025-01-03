package com.example.parkinglot;

import com.example.parkinglot.common.CarDto;
import com.example.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {
    @Inject
     CarsBean carsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<CarDto>cars=carsBean.findAllCars();
        request.setAttribute("cars",cars);
        request.setAttribute("numberOfFreeParkingSpots", 10);
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
    }
}