package balachonov.controllers;

import balachonov.entities.User;
import balachonov.mappers.UserMapper;
import balachonov.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static balachonov.util.Constants.*;

@WebServlet(urlPatterns = "/user/registration")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserMapper.getUserMapper().simpleBuildUser(
                req.getParameter(USER_FIRST_NAME),
                req.getParameter(USER_LAST_NAME),
                req.getParameter(USER_EMAIL),
                req.getParameter(USER_ADDRESS),
                req.getParameter(USER_PASSWORD)
        );
        UserServiceImpl.getUserServiceImpl().simpleCreate(user);
        HttpSession session = req.getSession();
        session.setAttribute(USER, user);
        req.getRequestDispatcher(PAGE_USER_OPENING_MENU).forward(req, resp);
    }
}