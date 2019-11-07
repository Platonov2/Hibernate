package org.TFG.project;

import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        DBControler dbControler = new DBControler();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        dbControler.addUser(login,password, email);

        request.getRequestDispatcher("/authorization.html").forward(request, response);
    }
}
