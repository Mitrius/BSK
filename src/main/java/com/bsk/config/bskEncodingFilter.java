package com.bsk.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class bskEncodingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
