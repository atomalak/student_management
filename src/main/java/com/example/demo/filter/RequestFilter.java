package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.example.demo.exceptions.UrlNotAcceptableException;

@Component
public class RequestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(servletReq);
		HttpServletRequest httpReq=(HttpServletRequest)servletReq;
		String headerInfo=httpReq.getHeader("Authorization");
		if(httpReq.getRequestURI().equals("/get-all-students") && (headerInfo!=null && !headerInfo.equals("Demo"))){
			throw new UrlNotAcceptableException("user is invalid");
		}
		
		chain.doFilter(servletReq, servletResp);
		
	}

}
