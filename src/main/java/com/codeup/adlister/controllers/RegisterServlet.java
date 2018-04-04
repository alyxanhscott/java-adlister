package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        boolean validUsername = username.length() <= 50 && username.length() > 8;
        boolean validPass = password.length() <= 50 && password.length() > 6 && !password.contains(username);
        boolean validEmail = email.length() <= 50 && email.length() > 5 && email.contains("@");


        if (validEmail && validPass && validUsername) {
            User u = new User(0, username, email, password);
            long r = DaoFactory.getUsersDao().insert(u);
            if (r > 0) {
                request.getSession().setAttribute("user", DaoFactory.getUsersDao().findByUsername(username));
                response.sendRedirect("/profile");
            }
        } else {
            response.sendRedirect("/register");
        }
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
    }
}
