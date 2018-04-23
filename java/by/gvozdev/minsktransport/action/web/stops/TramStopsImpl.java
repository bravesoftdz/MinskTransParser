package by.gvozdev.minsktransport.action.web.stops;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import by.gvozdev.minsktransport.action.BaseAction;
import by.gvozdev.minsktransport.bean.Stop;
import by.gvozdev.minsktransport.bean.entity.StopsName;
import by.gvozdev.minsktransport.constant.ResponseSetting;
import by.gvozdev.minsktransport.dao.impl.ParseSiteStopsImpl;
import by.gvozdev.minsktransport.util.NoDataReply;

public class TramStopsImpl implements BaseAction {

	private ParseSiteStopsImpl dao = new ParseSiteStopsImpl();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String action = request.getParameter("action");
		String transport = request.getParameter("transport");
		String number = request.getParameter("number");
		int day = Integer.valueOf(request.getParameter("day"));

		Stop stop = new Stop();
		stop.setAction(action);
		stop.setTransport(transport);
		stop.setNumber(number);
		stop.setDay(day);

		Map<String, Map<String, List<StopsName>>> stops = dao.getTramStops(stop);

		PrintWriter out = response.getWriter();

		if (stops != null) {
			String json = new Gson().toJson(stops);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("TramStopsImpl", "getTramStops");
			out.print(answer);
			out.close();
		}

	}

}
