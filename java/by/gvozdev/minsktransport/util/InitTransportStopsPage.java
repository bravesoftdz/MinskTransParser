package by.gvozdev.minsktransport.util;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import by.gvozdev.minsktransport.constant.UrlParseSite;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class InitTransportStopsPage {

	public Document getPageBusStops(String transport, String number, int day) throws IOException {
		String partQuery = "Transport=" + transport + "&n=" + number + "&day=" + day + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

	public Document getPageTrolleybusStops(String transport, String number, int day) throws IOException {
		String partQuery = "n=" + number + "&submit=OK&Transport=" + transport + "&day=" + day + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

	public Document getPageTramStops(String transport, String number, int day) throws IOException {
		String partQuery = "n=" + number + "&submit=OK&Transport=" + transport + "&day=" + day + "";
		String url = UrlParseSite.URL_RESOURCE + partQuery;
		Document page = Jsoup.parse(new URL(url), 3000);
		return page;
	}

}
