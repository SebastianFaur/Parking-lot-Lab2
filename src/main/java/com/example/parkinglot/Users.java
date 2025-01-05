package com.example.parkinglot;

import com.example.parkinglot.common.UserDto;
import com.example.parkinglot.ejb.PasswordBean;
import com.example.parkinglot.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"READ_USERS"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_USERS"})
        }
)
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    private UserBean userBean;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obține lista de utilizatori din UsersBean
        List<UserDto> users = userBean.findAllUsers();

        // Setează datele în request pentru utilizare în JSP
        request.setAttribute("users", users);
        request.setAttribute("numberOfUsers", users.size());

        // Forward către pagina JSP
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
    }
}