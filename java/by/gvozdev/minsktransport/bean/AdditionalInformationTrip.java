package by.gvozdev.minsktransport.bean;

/**
 * @author Gvozdev Alexsander Apr 23, 2018
 */
public class AdditionalInformationTrip {

	private int day;
	private String nameDayRu;
	private String nameDayEn;
	private String discription;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getNameDayRu() {
		return nameDayRu;
	}

	public void setNameDayRu(String nameDayRu) {
		this.nameDayRu = nameDayRu;
	}

	public String getNameDayEn() {
		return nameDayEn;
	}

	public void setNameDayEn(String nameDayEn) {
		this.nameDayEn = nameDayEn;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((nameDayEn == null) ? 0 : nameDayEn.hashCode());
		result = prime * result + ((nameDayRu == null) ? 0 : nameDayRu.hashCode());
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
		AdditionalInformationTrip other = (AdditionalInformationTrip) obj;
		if (day != other.day)
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (nameDayEn == null) {
			if (other.nameDayEn != null)
				return false;
		} else if (!nameDayEn.equals(other.nameDayEn))
			return false;
		if (nameDayRu == null) {
			if (other.nameDayRu != null)
				return false;
		} else if (!nameDayRu.equals(other.nameDayRu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdditionalInformationTrip [day=" + day + ", nameDayRu=" + nameDayRu + ", nameDayEn=" + nameDayEn
				+ ", discription=" + discription + "]";
	}

}
