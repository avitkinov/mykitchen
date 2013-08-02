package mykitchen.web.filters;

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
import javax.servlet.http.HttpSession;

import mykitchen.web.managedbeans.UserSessionHelper;

/**
 * Blocks access to the application for not logged in users.
 * 
 * @author Asparuh Vitkinov
 */
@WebFilter("/application/*")
public class LoginFilter implements Filter {
	private static final String LOG_IN_PAGE = "/login.jsf";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest requset, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) requset;
		HttpSession session = httpServletRequest.getSession();
		if (session.getAttribute(UserSessionHelper.LOG_IN_USER) != null) {
			chain.doFilter(requset, response);
		} else {
			HttpServletResponse httpSevletResponse = (HttpServletResponse) response;
			httpSevletResponse.sendRedirect(httpServletRequest.getContextPath()
					+ LOG_IN_PAGE);
		}
	}

}
