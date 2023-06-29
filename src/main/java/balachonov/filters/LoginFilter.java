package balachonov.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static balachonov.util.Constants.PAGE_SING_IN;

@WebFilter(urlPatterns = "/pages/*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + PAGE_SING_IN;
        boolean loggedIn = (session != null) && (session.getAttribute("user") != null);
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        if (loggedIn || loginRequest) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(PAGE_SING_IN);
        }
    }
}