package by.gvozdev.minsktransport.bean;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class Schedule {

	private String action;
	private String transport;
	private String number;
	private int day;
	private String stopId;
	private String routeA;
	private String routrB;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getStopId() {
		return stopId;
	}

	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	public String getRouteA() {
		return routeA;
	}

	public void setRouteA(String routeA) {
		this.routeA = routeA;
	}

	public String getRoutrB() {
		return routrB;
	}

	public void setRoutrB(String routrB) {
		this.routrB = routrB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + day;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((routeA == null) ? 0 : routeA.hashCode());
		result = prime * result + ((routrB == null) ? 0 : routrB.hashCode());
		result = prime * result + ((stopId == null) ? 0 : stopId.hashCode());
		result = prime * result + ((transport == null) ? 0 : transport.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (day != other.day)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (routeA == null) {
			if (other.routeA != null)
				return false;
		} else if (!routeA.equals(other.routeA))
			return false;
		if (routrB == null) {
			if (other.routrB != null)
				return false;
		} else if (!routrB.equals(other.routrB))
			return false;
		if (stopId == null) {
			if (other.stopId != null)
				return false;
		} else if (!stopId.equals(other.stopId))
			return false;
		if (transport == null) {
			if (other.transport != null)
				return false;
		} else if (!transport.equals(other.transport))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [action=" + action + ", transport=" + transport + ", number=" + number + ", day=" + day
				+ ", stopId=" + stopId + ", routeA=" + routeA + ", routrB=" + routrB + "]";
	}

}
