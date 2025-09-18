package jp.co.sss.crud.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

@Component
public class LoginCheckFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//リクエストURLを取得
		String requestURL = request.getRequestURI();
		if (requestURL.indexOf("/html/") != - 1 ||
				requestURL.indexOf("/css/") != - 1 ||
				requestURL.indexOf("/img/") != - 1 ||
				requestURL.indexOf("/js/") != - 1 ||
						requestURL.endsWith("/") ||
						requestURL.endsWith("/login")
				) {
			chain.doFilter(request, response);
			
		} else {
				HttpSession session = request.getSession();
				EmployeeBean userId = (EmployeeBean) session.getAttribute("loginUser");
			
			if (userId == null) {
				response.sendRedirect("/spring_crud/");
				return;
			} else {
				chain.doFilter(request, response);
			}
			
		}
	}

}
