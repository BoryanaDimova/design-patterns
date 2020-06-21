package courierCompany;

public class ForeignCountryShipmentEmployee extends Employee {
	public ForeignCountryShipmentEmployee() {
		this.name = "Foreign Country Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.FOREIGN_COUNTRY_SHIPMENT;
	}

	@Override
	void registerShipment(String destination) {	
			System.out.printf("%s registered new shipment for %s!\n", this.name, destination);
			preparation.applyState(this);
	}
}
