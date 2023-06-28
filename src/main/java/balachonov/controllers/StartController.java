package balachonov.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static balachonov.util.Constants.*;

@WebServlet(urlPatterns = "/choice-input")
public class StartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter(CHOICE_REQUEST);
        switch (choice) {
            case BUTTON_SING_IN:
                req.getRequestDispatcher(PAGE_SING_IN).forward(req, resp);
                break;
            case BUTTON_REGISTER:
                req.getRequestDispatcher(PAGE_REGISTER).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher(PAGE_INDEX).forward(req, resp);
        }
    }
}
