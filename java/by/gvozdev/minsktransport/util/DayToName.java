package by.gvozdev.minsktransport.util;

import java.util.HashMap;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class DayToName {

	HashMap<Integer, String> listRU = new HashMap<>();
	HashMap<Integer, String> listEN = new HashMap<>();

	public DayToName() {

		listRU.put(1, "Понедельник");
		listRU.put(2, "Вторник");
		listRU.put(3, "Среча");
		listRU.put(4, "Четверг");
		listRU.put(5, "Пятница");
		listRU.put(6, "Суббота");
		listRU.put(7, "Воскресенье");

		listEN.put(1, "Monday");
		listEN.put(2, "Tuesday");
		listEN.put(3, "Wednesday");
		listEN.put(4, "Thursday");
		listEN.put(5, "Friday");
		listEN.put(6, "Saturday");
		listEN.put(7, "Sunday");
	}

	public String getNameDayRU(int day) {
		String nameDay = listRU.get(day);
		return nameDay;
	}

	public String getNameDayEN(int day) {
		String nameDay = listEN.get(day);
		return nameDay;
	}

}
