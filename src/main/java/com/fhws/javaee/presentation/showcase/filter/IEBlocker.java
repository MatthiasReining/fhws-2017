package com.fhws.javaee.presentation.showcase.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"})
public class IEBlocker implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println("vor filter");
           
        String userAgent = ((HttpServletRequest)request).getHeader("User-Agent");
        
        if( userAgent.toLowerCase().contains("trident")) {
            //Internet Explorer - evil!
            ((HttpServletResponse)response).getWriter().println("IE finden wir doof!");
            return;
        }       
        
        chain.doFilter(request, response);
        //System.out.println("nach filter");
        
    }

    @Override
    public void destroy() {
    }

}
