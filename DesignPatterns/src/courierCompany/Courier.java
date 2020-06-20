package courierCompany;

import java.util.HashSet;


public class Courier implements Observer {

	private static Courier instance;
	private HashSet<Observable> employees = new HashSet();
	
	private Courier() {
	}
	
	public static Courier getInstance() {
		if(instance == null) {
			instance = new Courier();
		}
		return instance;
	}
	
	
	@Override
	public void update(Observable employee) {
	if(employees.contains(employee)) {
		System.out.println("The courier get a shipment from  "+ employee.getName() + ".");
		employee.setState(new WaitingState());
	}

	}

	@Override
	public void addObservable(Observable employee) {
		employees.add(employee);
	}

}
