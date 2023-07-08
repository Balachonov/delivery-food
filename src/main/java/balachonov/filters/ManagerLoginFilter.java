package balachonov.filters;

import balachonov.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static balachonov.entities.UserRole.ADMIN;
import static balachonov.entities.UserRole.MANAGER;
import static balachonov.util.Constants.PAGE_SING_IN;

@WebFilter(urlPatterns = "/pages/manager/*")
public class ManagerLoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if ((session != null) && (session.getAttribute("user") != null)) {
            User user = (User) session.getAttribute("user");
            String userRole = String.valueOf(user.getUserRole());
            if (userRole.equalsIgnoreCase(String.valueOf(ADMIN)) ||
                    userRole.equalsIgnoreCase(String.valueOf(MANAGER))) {
                chain.doFilter(req, res);
            }
        } else {
            res.sendRedirect(PAGE_SING_IN);
        }
    }
}