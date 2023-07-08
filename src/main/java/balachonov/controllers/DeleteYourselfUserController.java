package balachonov.controllers;

import balachonov.entities.User;
import balachonov.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static balachonov.util.Constants.*;

@WebServlet(urlPatterns = "/user/delete-yourself")
public class DeleteYourselfUserController extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userInSession = (User) session.getAttribute(USER);
        String userInputEmail = req.getParameter(USER_EMAIL);
        if (userInputEmail.equalsIgnoreCase(userInSession.getEmail())) {
            UserServiceImpl.getUserServiceImpl().deleteUser(userInSession.getIdUser());
        }
        req.getRequestDispatcher(PAGE_REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDelete(req, resp);
    }
}
