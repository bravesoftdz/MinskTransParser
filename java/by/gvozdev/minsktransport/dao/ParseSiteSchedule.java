package by.gvozdev.minsktransport.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import by.gvozdev.minsktransport.bean.Schedule;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public interface ParseSiteSchedule {

	Map<String, Map<String, List<Schedule>>> getBusSchedule(Schedule schedule) throws IOException;

	Map<String, Map<String, List<Schedule>>> getTrolleyBusSchedule(Schedule schedule) throws IOException;

	Map<String, Map<String, List<Schedule>>> getTramSchedule(Schedule schedule) throws IOException;

}
