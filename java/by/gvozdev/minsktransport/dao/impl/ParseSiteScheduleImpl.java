package by.gvozdev.minsktransport.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import by.gvozdev.minsktransport.bean.Schedule;
import by.gvozdev.minsktransport.dao.ParseSiteSchedule;
import by.gvozdev.minsktransport.util.InitTransportSchedulePage;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class ParseSiteScheduleImpl implements ParseSiteSchedule {

	@Override
	public Map<String, Map<String, List<Schedule>>> getBusSchedule(Schedule schedule) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, List<Schedule>>> getTrolleyBusSchedule(Schedule schedule) throws IOException {

		InitTransportSchedulePage initTransportSchedulePage = new InitTransportSchedulePage();

		try {

			String transport = schedule.getTransport();
			String number = schedule.getNumber();
			int day = schedule.getDay();
			String stopId = schedule.getStopId();
			String routeA = schedule.getRouteA();
			String routrB = schedule.getRoutrB();

			Document page = initTransportSchedulePage.getPageTrolleybusSchedule(transport, number, day, stopId, routeA,
					routrB);
			Elements elementHour = page.select("b");

			System.out.println(page);

			for (int i = 1; i < elementHour.size(); i++) {
				String hour = elementHour.get(i).toString();
				// System.out.println(Jsoup.parse(hour).text());
			}

			return null;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Map<String, Map<String, List<Schedule>>> getTramSchedule(Schedule schedule) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
