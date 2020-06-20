package courierCompany;

public class InnerShipmentEmployee extends Employee {

	public InnerShipmentEmployee() {
		this.name = "Inner Shipment Employee";
		waiting.applyState(this);
		this.level = Employee.INNER_SHIPMENT;
	}


}
