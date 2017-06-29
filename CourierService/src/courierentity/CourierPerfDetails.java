package courierentity;

import java.util.List;

public class CourierPerfDetails {

	private String courrierNo;
	private String noOfDeliveries;
	private String bonus;
	private String courierName;

	List<Courier> couriers;
	
	

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getCourrierNo() {
		return courrierNo;
	}

	public void setCourrierNo(String courrierNo) {
		this.courrierNo = courrierNo;
	}

	public String getNoOfDeliveries() {
		return noOfDeliveries;
	}

	public void setNoOfDeliveries(String noOfDeliveries) {
		this.noOfDeliveries = noOfDeliveries;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}

}
