package courierCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import onlineChatRoom.User;

public class CourierCompanyMain {

	public static void main(String[] args) {
		Employee couriers = generateChain();

		
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
     boolean exit = false;
     System.out.println("Hello! We are a courier company.");
     System.out.println("----- Commands to use: -------");
     System.out.println("For exit press 0.");
     System.out.println("For inner shipment in Plovdiv press 1.");
     System.out.println("For shipment in the country press 2.");
     System.out.println("For foreign country shipment press 3.");
     System.out.println("------------------------------\n\n");
     do {
     	  System.out.print("---------------------------\n\nEnter command:");
	          Integer command = -1;
	        try {
				command = Integer.valueOf(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          switch (command) {
				case 1: {
					couriers.takeShipment(Employee.INNER_SHIPMENT);
					break;
				}
				case 2: {
					couriers.takeShipment(Employee.COUNTRY_SHIPMENT);
					break;
				}
				case 3: {
					couriers.takeShipment(Employee.FOREIGN_COUNTRY_SHIPMENT);
					break;
				}
				case 0: {
					exit = true;
					break;
				}
			}
     	
     }while(!exit);
     
     try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		couriers.takeShipment(Employee.INNER_SHIPMENT);
//		System.out.println("----------------------------------");
//		couriers.takeShipment(Employee.INNER_SHIPMENT);
//		System.out.println("----------------------------------");
//		couriers.takeShipment(Employee.COUNTRY_SHIPMENT);
//		System.out.println("----------------------------------");
//		couriers.takeShipment(Employee.FOREIGN_COUNTRY_SHIPMENT);
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
