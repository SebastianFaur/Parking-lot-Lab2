package com.example.parkinglot;

import com.example.parkinglot.ejb.PasswordBean;
import com.example.parkinglot.ejb.UserBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AddUser", value = "/AddUser")
@DeclareRoles({"READ_USERS", "WRITE_USERS"})
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"WRITE_USERS"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_USERS"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"WRITE_USERS"})
        }
)
public class AddUser extends HttpServlet {
    @Inject
    UserBean userBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.setAttribute("userGroups", new String[] {"READ_CARS", "WRITE_CARS", "READ_USERS", "WRITE_USERS"});
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String[] userGroups =
                request.getParameterValues("user_groups");
        if (userGroups == null) {
            userGroups = new String[0];
        }
        userBean.createUser(username, email, password, Arrays.asList(userGroups));
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}