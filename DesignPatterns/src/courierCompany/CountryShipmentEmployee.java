package courierCompany;

public class CountryShipmentEmployee extends Employee {
	public CountryShipmentEmployee() {
		this.name = "Country Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.COUNTRY_SHIPMENT;
	}
}
