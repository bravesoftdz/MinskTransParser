package by.gvozdev.minsktransport.bean.entity;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class StopsName {

	private String stopName;
	private String stopId;
	private String routeType;

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getStopId() {
		return stopId;
	}

	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeType == null) ? 0 : routeType.hashCode());
		result = prime * result + ((stopId == null) ? 0 : stopId.hashCode());
		result = prime * result + ((stopName == null) ? 0 : stopName.hashCode());
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
		StopsName other = (StopsName) obj;
		if (routeType == null) {
			if (other.routeType != null)
				return false;
		} else if (!routeType.equals(other.routeType))
			return false;
		if (stopId == null) {
			if (other.stopId != null)
				return false;
		} else if (!stopId.equals(other.stopId))
			return false;
		if (stopName == null) {
			if (other.stopName != null)
				return false;
		} else if (!stopName.equals(other.stopName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StopsName [stopName=" + stopName + ", stopId=" + stopId + ", routeType=" + routeType + "]";
	}

}
