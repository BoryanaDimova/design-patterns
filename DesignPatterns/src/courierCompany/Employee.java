package courierCompany;

import java.util.ArrayList;
import java.util.List;


public abstract class Employee implements Observable {

	protected State waiting = new WaitingState();
	protected State preparation = new PreparationState();
	
	public static int INNER_SHIPMENT = 1;
	public static int COUNTRY_SHIPMENT = 2;
	public static int FOREIGN_COUNTRY_SHIPMENT = 3;
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	protected String name;
	protected int level;
	protected State state;
	protected Employee nextEmployee;
	
	public State getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	
	@Override
	public void setState(State state) {
		this.state = state;
		System.out.printf("\t-> %s changed his state to %s.\r\n", this.name, state.getStateName());
		if(preparation == state)
		this.notifySpectators();
	}
	
	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}
	
	public void takeShipment(int level) {
		
		if(this.level <= level) {
			// Method to consume the data passed
			this.registerShipment();
			return;
		}
		
		if(this.nextEmployee != null) {
			this.nextEmployee.takeShipment(level);
		}
		
	}
	
	protected void registerShipment() {
		System.out.println(this.name+" registered new shipment!");
		preparation.applyState(this);
	}
	
	

	@Override
	public void registerSpectator(Observer spectator) {
		this.observers.add(spectator);
		spectator.addObservable(this);
		
	}

	@Override
	public void unregisterSpectator(Observer spectator) {
		this.observers.remove(spectator);
		
	}

	@Override
	public void notifySpectators() {
		for(Observer observer: this.observers) {
			observer.update(this);
		}
		
	}

	@Override
	public Object getUpdate() {
		// TODO Auto-generated method stub
		return this.state;
	}
	
}
