package courierCompany;

public class CourierCompanyMain {

	public static void main(String[] args) {
		Employee couriers = generateChain();

		couriers.takeShipment(Employee.INNER_SHIPMENT);
		System.out.println("----------------------------------");
		couriers.takeShipment(Employee.INNER_SHIPMENT);
		System.out.println("----------------------------------");
		couriers.takeShipment(Employee.COUNTRY_SHIPMENT);
		System.out.println("----------------------------------");
		couriers.takeShipment(Employee.FOREIGN_COUNTRY_SHIPMENT);
	}

	private static Employee generateChain() {
		Courier courier = Courier.getInstance();
		
		Employee innerShipmentEmployee = new InnerShipmentEmployee();
		innerShipmentEmployee.registerSpectator(courier);
		Employee countryShipmentEmployee = new CountryShipmentEmployee();
		countryShipmentEmployee.registerSpectator(courier);
		Employee foreignCountryShipmentEmployee = new ForeignCountryShipmentEmployee();
		foreignCountryShipmentEmployee.registerSpectator(courier);
		
		foreignCountryShipmentEmployee.setNextEmployee(countryShipmentEmployee);
		countryShipmentEmployee.setNextEmployee(innerShipmentEmployee);
		
		return foreignCountryShipmentEmployee;
	}
}
