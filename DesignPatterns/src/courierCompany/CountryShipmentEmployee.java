package courierCompany;

public class CountryShipmentEmployee extends Employee {
	public CountryShipmentEmployee() {
		this.name = "Country Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.COUNTRY_SHIPMENT;
	}

	@Override
	void registerShipment(String destination) {
		System.out.printf("%s registered new shipment for %s!\n", this.name, destination);
		preparation.applyState(this);	
	}
}
