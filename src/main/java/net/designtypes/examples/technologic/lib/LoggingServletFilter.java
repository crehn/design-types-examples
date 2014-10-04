package net.designtypes.examples.technologic.lib;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingServletFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			log.info(httpRequest.getMethod() + " " + httpRequest.getRequestURL());
		}
		
		chain.doFilter(request, response);

		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			log.info("returning " + httpResponse.getStatus());
		}
	}
	
	@Override
	public void destroy() {}
	
}
