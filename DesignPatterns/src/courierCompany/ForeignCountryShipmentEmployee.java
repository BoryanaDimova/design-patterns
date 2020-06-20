package courierCompany;

public class ForeignCountryShipmentEmployee extends Employee {
	public ForeignCountryShipmentEmployee() {
		this.name = "Foreign Country Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.FOREIGN_COUNTRY_SHIPMENT;
	}
}
