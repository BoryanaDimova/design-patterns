package courierCompany;

public class InnerShipmentEmployee extends Employee {

	public InnerShipmentEmployee() {
		this.name = "Inner Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.INNER_SHIPMENT;
	}

	@Override
	void registerShipment(String destination) {
		System.out.printf("%s registered new shipment for %s!\n", this.name, destination);
		preparation.applyState(this);	
	}


}
