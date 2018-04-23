package by.gvozdev.minsktransport.dao.impl;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import by.gvozdev.minsktransport.bean.Stop;
import by.gvozdev.minsktransport.bean.entity.StopsName;
import by.gvozdev.minsktransport.dao.ParserSiteStops;
import by.gvozdev.minsktransport.util.DayToName;
import by.gvozdev.minsktransport.util.InitTransportStopsPage;

public class ParseSiteStopsImpl implements ParserSiteStops {

	@SuppressWarnings("unused")
	@Override
	public Map<String, Map<String, List<StopsName>>> getBusStops(Stop stop) throws IOException {
		//http://localhost/MinskTrans/TransportStops?action=getBusStops&transport=Autobus&number=37&day=1
		List<StopsName> listRouteA = new ArrayList<>();
		List<StopsName> listRouteB = new ArrayList<>();

		Map<String, List<StopsName>> arrStops = new HashMap<>();
		Map<String, Map<String, List<StopsName>>> json = new HashMap<>();

		InitTransportStopsPage initTransportStopsPage = new InitTransportStopsPage();

		String busdirection_1 = "";
		String busdirection_2 = "";
		String dataBusStop = "";
		String nameRouteA = "";
		String nameRouteB = "";
		String disciption = "";

		try {

			String transport = stop.getTransport();
			String number = stop.getNumber();
			int day = stop.getDay();

			Document page = initTransportStopsPage.getPageBusStops(transport, number, day);
			Elements elementBusDirection = page.select("b");

			for (Element e : elementBusDirection) {
				busdirection_1 = elementBusDirection.get(elementBusDirection.size() - 1).toString();
				busdirection_2 = elementBusDirection.get(elementBusDirection.size() - 2).toString();
			}

			Elements elementBusStops = page.select("a[href]");

			for (int i = 10; i < elementBusStops.size(); i++) {

				dataBusStop = elementBusStops.get(i).toString();
				String stopId = StringUtils.substringBetween(dataBusStop, "StopID=", "&");
				String directionType = StringUtils.substringBetween(dataBusStop, "RouteType=", "%");

				String tag = elementBusStops.get(i).toString();
				String stopName = Jsoup.parse(tag).text();

				StopsName sn = new StopsName();
				nameRouteB = Jsoup.parse(busdirection_1).text();
				nameRouteA = Jsoup.parse(busdirection_2).text();

				switch (directionType) {
				case "A":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteA.add(sn);
					arrStops.put("A", listRouteA);
					break;
				case "B":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteB.add(sn);
					arrStops.put("B", listRouteB);
					break;
				default:
					break;
				}

			}

			DayToName dayToName = new DayToName();
			String dayRu = dayToName.getNameDayRU(day);
			String dayEn = dayToName.getNameDayEN(day);

			disciption = "[" + transport + "]" + "[" + number + "]" + "[" + day + "]" + "[" + dayRu + "]" + "[" + dayEn
					+ "]";

			json.put(disciption, arrStops);
			return json;

		} catch (Exception e) {
			json.put("NoData", arrStops);
			return json;
		}

	}

	@SuppressWarnings("unused")
	@Override
	public Map<String, Map<String, List<StopsName>>> getTrolleyBusStops(Stop stop) throws IOException {
		//http://localhost/MinskTrans/TransportStops?action=getTramStops&transport=Trolleybus&number=61&day=1
		List<StopsName> listRouteA = new ArrayList<>();
		List<StopsName> listRouteB = new ArrayList<>();

		Map<String, List<StopsName>> arrStops = new HashMap<>();
		Map<String, Map<String, List<StopsName>>> json = new HashMap<>();

		InitTransportStopsPage initTransportStopsPage = new InitTransportStopsPage();

		String busdirection_1 = "";
		String busdirection_2 = "";
		String dataBusStop = "";
		String nameRouteA = "";
		String nameRouteB = "";
		String disciption = "";

		try {

			String transport = stop.getTransport();
			String number = stop.getNumber();
			int day = stop.getDay();

			Document page = initTransportStopsPage.getPageTrolleybusStops(transport, number, day);
			Elements elementBusDirection = page.select("b");

			for (Element e : elementBusDirection) {
				busdirection_1 = elementBusDirection.get(elementBusDirection.size() - 1).toString();
				busdirection_2 = elementBusDirection.get(elementBusDirection.size() - 2).toString();
			}

			Elements elementBusStops = page.select("a[href]");

			for (int i = 10; i < elementBusStops.size(); i++) {

				dataBusStop = elementBusStops.get(i).toString();
				String stopId = StringUtils.substringBetween(dataBusStop, "StopID=", "&");
				String directionType = StringUtils.substringBetween(dataBusStop, "RouteType=", "%");

				String tag = elementBusStops.get(i).toString();
				String stopName = Jsoup.parse(tag).text();

				StopsName sn = new StopsName();
				nameRouteB = Jsoup.parse(busdirection_1).text();
				nameRouteA = Jsoup.parse(busdirection_2).text();

				switch (directionType) {
				case "A":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteA.add(sn);
					arrStops.put("A", listRouteA);
					break;
				case "B":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteB.add(sn);
					arrStops.put("B", listRouteB);
					break;
				default:
					break;
				}

			}

			DayToName dayToName = new DayToName();
			String dayRu = dayToName.getNameDayRU(day);
			String dayEn = dayToName.getNameDayEN(day);

			disciption = "[" + transport + "]" + "[" + number + "]" + "[" + day + "]" + "[" + dayRu + "]" + "[" + dayEn
					+ "]";

			json.put(disciption, arrStops);
			return json;

		} catch (Exception e) {
			json.put("NoData", arrStops);
			return json;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public Map<String, Map<String, List<StopsName>>> getTramStops(Stop stop) throws IOException {
		//http://localhost/MinskTrans/ServletConnectorController?action=getTrolleybusStops&transport=Tramway&number=6&day=1
		List<StopsName> listRouteA = new ArrayList<>();
		List<StopsName> listRouteB = new ArrayList<>();

		Map<String, List<StopsName>> arrStops = new HashMap<>();
		Map<String, Map<String, List<StopsName>>> json = new HashMap<>();

		InitTransportStopsPage initTransportStopsPage = new InitTransportStopsPage();

		String busdirection_1 = "";
		String busdirection_2 = "";
		String dataBusStop = "";
		String nameRouteA = "";
		String nameRouteB = "";
		String disciption = "";

		try {

			String transport = stop.getTransport();
			String number = stop.getNumber();
			int day = stop.getDay();

			Document page = initTransportStopsPage.getPageTrolleybusStops(transport, number, day);
			Elements elementBusDirection = page.select("b");

			for (Element e : elementBusDirection) {
				busdirection_1 = elementBusDirection.get(elementBusDirection.size() - 1).toString();
				busdirection_2 = elementBusDirection.get(elementBusDirection.size() - 2).toString();
			}

			Elements elementBusStops = page.select("a[href]");

			for (int i = 10; i < elementBusStops.size(); i++) {

				dataBusStop = elementBusStops.get(i).toString();
				String stopId = StringUtils.substringBetween(dataBusStop, "StopID=", "&");
				String directionType = StringUtils.substringBetween(dataBusStop, "RouteType=", "%");

				String tag = elementBusStops.get(i).toString();
				String stopName = Jsoup.parse(tag).text();

				StopsName sn = new StopsName();
				nameRouteB = Jsoup.parse(busdirection_1).text();
				nameRouteA = Jsoup.parse(busdirection_2).text();

				switch (directionType) {
				case "A":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteA.add(sn);
					arrStops.put("A", listRouteA);
					break;
				case "B":
					sn.setStopId(stopId);
					sn.setStopName(stopName);
					sn.setRouteType(directionType);
					listRouteB.add(sn);
					arrStops.put("B", listRouteB);
					break;
				default:
					break;
				}

			}

			DayToName dayToName = new DayToName();
			String dayRu = dayToName.getNameDayRU(day);
			String dayEn = dayToName.getNameDayEN(day);

			disciption = "[" + transport + "]" + "[" + number + "]" + "[" + day + "]" + "[" + dayRu + "]" + "[" + dayEn
					+ "]";

			json.put(disciption, arrStops);
			return json;

		} catch (Exception e) {
			json.put("NoData", arrStops);
			return json;
		}
	}

}
