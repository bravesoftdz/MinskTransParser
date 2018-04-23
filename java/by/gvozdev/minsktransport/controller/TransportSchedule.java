package by.gvozdev.minsktransport.controller;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gvozdev.minsktransport.action.ActionManager;
import by.gvozdev.minsktransport.action.BaseAction;
import by.gvozdev.minsktransport.constant.ResponseSetting;
import by.gvozdev.minsktransport.constant.ServletControllerSettings;
import by.gvozdev.minsktransport.constant.ServletParameters;

@WebServlet("/TransportSchedule")
public class TransportSchedule extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;
	private String encoding;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		synchronized (this) {
			String contentType = request.getContentType();
			if (contentType != null && contentType.startsWith(ServletControllerSettings.FILTERABLE_CONTENT_TYPE))
				request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter(ServletControllerSettings.ENCODING_INIT_PARAM_NAME);
		if (encoding == null)
			encoding = ServletControllerSettings.ENCODING_DEFAULT;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(ResponseSetting.CONTENT_TYPE_HTML);
		response.addHeader(ResponseSetting.ACCESS_HEADER, ResponseSetting.ACCESS_HEADER_TRUE);
		String userAction = request.getParameter(ServletParameters.PARAM_VALUE_ACTTION);
		String value = userAction;

		BaseAction action = ActionManager.defineAction(value);
		action.doHttpReqRes(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
