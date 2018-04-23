package by.gvozdev.minsktransport.dao;

import java.io.IOException;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.util.List;
import java.util.Map;

import by.gvozdev.minsktransport.bean.Stop;
import by.gvozdev.minsktransport.bean.entity.StopsName;

public interface ParserSiteStops {

	Map<String, Map<String, List<StopsName>>> getBusStops(Stop stop) throws IOException;

	Map<String, Map<String, List<StopsName>>> getTrolleyBusStops(Stop stop) throws IOException;

	Map<String, Map<String, List<StopsName>>> getTramStops(Stop stop) throws IOException;

}
