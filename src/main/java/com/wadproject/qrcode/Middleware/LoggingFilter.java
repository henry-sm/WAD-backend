package com.wadproject.qrcode.Middleware;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("[INFO] Incoming Request: " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);  // Proceed with the next filter/controller

        System.out.println("[INFO] Response Status: " + res.getStatus());
    }
}
