package by.gvozdev.minsktransport.action;

/**
 * @author Gvozdev Alexsander
 * Apr 23, 2018
 */

import java.util.HashMap;

import by.gvozdev.minsktransport.action.web.schedule.BusScheduleImpl;
import by.gvozdev.minsktransport.action.web.schedule.TramScheduleImpl;
import by.gvozdev.minsktransport.action.web.schedule.TrolleybusScheduleImpl;
import by.gvozdev.minsktransport.action.web.stops.BusStopsImpl;
import by.gvozdev.minsktransport.action.web.stops.TramStopsImpl;
import by.gvozdev.minsktransport.action.web.stops.TrolleybusStopsImpl;
import by.gvozdev.minsktransport.constant.ActionNameConstant;

public class ActionManager {

	public static BaseAction defineAction(String action) {

		HashMap<String, Object> listAction = new HashMap<>();
		listAction.put(ActionNameConstant.ACTION_GET_BUS_STOPS, new BusStopsImpl());
		listAction.put(ActionNameConstant.ACTION_GET_TROLLEYBUS_STOPS, new TrolleybusStopsImpl());
		listAction.put(ActionNameConstant.ACTION_GET_TRAM_STOPS, new TramStopsImpl());

		listAction.put(ActionNameConstant.ACTION_GET_BUS_SCHEDULE, new BusScheduleImpl());
		listAction.put(ActionNameConstant.ACTION_GET_TROLLEYBUS_SCHEDULE, new TrolleybusScheduleImpl());
		listAction.put(ActionNameConstant.ACTION_GET_TRAM_SCHEDULE, new TramScheduleImpl());

		BaseAction act = null;
		act = (BaseAction) listAction.get(action);
		return act;

	}

}
