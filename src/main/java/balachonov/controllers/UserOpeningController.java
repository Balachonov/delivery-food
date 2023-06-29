package balachonov.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static balachonov.util.Constants.*;

@WebServlet(urlPatterns = "/user/opening-menu")
public class UserOpeningController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter(REQUEST_CHOICE);
        switch (choice) {
            case BUTTON_UPDATE_PERSONAL_DATA:
                req.getRequestDispatcher(PAGE_UPDATE_PERSONAL_DATA).forward(req, resp);
                break;
            case BUTTON_VIEW_ALL_PRODUCTS:
                req.getRequestDispatcher(PAGE_ALL_FOODS).forward(req, resp);
                break;
            case BUTTON_DELETE_YOUR_ACCOUNT:
                req.getRequestDispatcher(PAGE_DELETE_YOUR_ACCOUNT).forward(req, resp);
                break;
            case BUTTON_EXIT:
                HttpSession session = req.getSession();
                session.invalidate();
                req.getRequestDispatcher(PAGE_INDEX).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher(PAGE_INDEX).forward(req, resp);
        }
    }
}
