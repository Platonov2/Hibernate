package org.TFG.project;

import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        DBControler dbControler = new DBControler();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String href = "http://localhost:8000/?path=C:\\Users\\student\\Desktop\\test\\" + login;

        UserProfile userProfile = dbControler.getUser(login);

        if (userProfile == null || !password.equals(userProfile.getPassword())){
            request.getRequestDispatcher("/authorization.html").forward(request, response);
            return;
        }

        String sessionId = request.getSession().getId();
        SessionService.addSession(sessionId, userProfile);

        response.sendRedirect(href);
    }
}
