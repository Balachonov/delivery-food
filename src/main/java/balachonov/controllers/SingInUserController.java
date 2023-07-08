package balachonov.controllers;

import balachonov.entities.User;
import balachonov.services.PasswordGenerationAndCheckImpl;
import balachonov.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static balachonov.util.Constants.*;

@WebServlet(urlPatterns = "/user/sing-in")
public class SingInUserController extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> userInDataBase = UserServiceImpl.getUserServiceImpl().
                getUserByEmail(req.getParameter(USER_EMAIL));
        String inputPassword = req.getParameter(USER_PASSWORD);
        if (userInDataBase.isPresent()) {
            User user = userInDataBase.get();
            String userPassword = user.getPassword();
            String userSalt = user.getSalt();
            checkingPassword(req, resp, inputPassword, user, userPassword, userSalt);
        } else req.getRequestDispatcher(PAGE_INVALID_USER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }


    private static void checkingPassword(HttpServletRequest req, HttpServletResponse resp, String inputPassword, User user, String userPassword, String userSalt) throws ServletException, IOException {
        if (PasswordGenerationAndCheckImpl.getPasswordGenerationAndCheck().
                checkPassword(inputPassword, userPassword, userSalt)) {
            HttpSession session = req.getSession();
            session.setAttribute(USER, user);
            req.getRequestDispatcher(PAGE_USER_OPENING_MENU).forward(req, resp);
        } else req.getRequestDispatcher(PAGE_INVALID_USER_PASSWORD).forward(req, resp);
    }
}
