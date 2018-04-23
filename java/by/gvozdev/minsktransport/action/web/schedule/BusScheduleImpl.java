package by.gvozdev.minsktransport.action.web.schedule;

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
import by.gvozdev.minsktransport.bean.Schedule;
import by.gvozdev.minsktransport.constant.ResponseSetting;
import by.gvozdev.minsktransport.dao.impl.ParseSiteScheduleImpl;
import by.gvozdev.minsktransport.util.NoDataReply;

public class BusScheduleImpl implements BaseAction {

	private ParseSiteScheduleImpl dao = new ParseSiteScheduleImpl();

	@Override
	public void doHttpReqRes(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String action = request.getParameter("action");
		String transport = request.getParameter("transport");
		String number = request.getParameter("number");
		int day = Integer.valueOf(request.getParameter("day"));
		String stopId = request.getParameter("stopId");
		String routeA = request.getParameter("routeA");
		String routrB = request.getParameter("routrB");

		Schedule schedule = new Schedule();
		schedule.setAction(action);
		schedule.setTransport(transport);
		schedule.setNumber(number);
		schedule.setDay(day);
		schedule.setStopId(stopId);
		schedule.setRouteA(routeA);
		schedule.setRoutrB(routrB);

		Map<String, Map<String, List<Schedule>>> sch = dao.getBusSchedule(schedule);

		PrintWriter out = response.getWriter();

		if (sch != null) {
			String json = new Gson().toJson(sch);
			response.setContentType(ResponseSetting.CONTENT_TYPE_JSON);
			response.setCharacterEncoding(ResponseSetting.CHARACTER_ENCODING);
			response.getWriter().write(json);
		} else {
			NoDataReply noDataReply = new NoDataReply();
			String answer = noDataReply.noDataReceived("BusScheduleImpl", "getBusSchedule");
			out.print(answer);
			out.close();
		}

	}

}
