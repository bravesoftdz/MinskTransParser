package by.gvozdev.minsktransport.util;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import by.gvozdev.minsktransport.constant.UrlParseSite;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class InitTransportSchedulePage {

	public Document getPageBusSchedule(String transport, String number, int day, String stopId, String routeA,
			String routrB) throws IOException {
		String partQuery = "RouteNum=" + number + "&StopID=" + stopId + "&RouteType=" + routeA + ">" + routrB + "&day="
				+ day + "&Transport=" + transport + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

	public Document getPageTrolleybusSchedule(String transport, String number, int day, String stopId, String routeA,
			String routrB) throws IOException {
		String partQuery = "RouteNum=" + number + "&StopID=" + stopId + "&RouteType=" + routeA + ">" + routrB + "&day="
				+ day + "&Transport=" + transport + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

	public Document getPageTramSchedule(String transport, String number, int day, String stopId, String routeA,
			String routrB) throws IOException {
		String partQuery = "RouteNum=" + number + "&StopID=" + stopId + "&RouteType=" + routeA + ">" + routrB + "&day="
				+ day + "&Transport=" + transport + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

}
