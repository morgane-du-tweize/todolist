package servlets;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


@WebFilter(
		filterName = "TodoFilter",
		urlPatterns="/*"
	)
public class TodoFilter implements Filter {

    public TodoFilter() {
    }

    @Override
	public void init(FilterConfig fConfig) throws ServletException {
	}    
    
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(
				new XssRquestWrapper ((HttpServletRequest) request), response);
	}
	
    @Override
	public void destroy() {
	}

	private static class XssRquestWrapper extends HttpServletRequestWrapper {

		private static final Pattern[] PATTERNS = {
			Pattern.compile("<.*?>"),
			Pattern.compile("&.*?;"),
			Pattern.compile("%[0-9a-fA-F]*")
		};
		
		public XssRquestWrapper(HttpServletRequest request) {
			super(request);
		}
		
		@Override
		public String[] getParameterValues(String name) {
			String[] values = super.getParameterValues(name);
			if (values == null) {
				return null;
			}
			int compteur = values.length;
			for (int i = 0 ; i < compteur ; i++) {
				values[i] =removeTags(values [i]);
			}
			return values ;
		}

		@Override
		public String getParameter(String name) {
			return removeTags(super.getParameter(name)) ;
		}
		
		@Override
		public String getHeader(String name) {
			return removeTags(super.getHeader(name)) ;
		}
		
		
		private String removeTags(String str) {
			if (str != null) {
				
				str = str.replaceAll("\0", "");

				for (Pattern aPattern : PATTERNS) {
					str = aPattern.matcher(str).replaceAll("");
				}			
				str = str.replaceAll("<", "");
				str = str.replaceAll(">", "");			
			}
			return str;
		}
		
	}
}
