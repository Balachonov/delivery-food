package balachonov.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static balachonov.util.Constants.*;

@WebFilter(urlPatterns = {"/user/update-personal-data", "/user/registration"})
public class PasswordFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String email = req.getParameter(USER_PASSWORD);
        Matcher matcher = Pattern.compile(REGEX_PASSWORD).matcher(email);

        if (matcher.matches()) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(PAGE_INVALID_PASSWORD_REGEX);
        }
    }
}