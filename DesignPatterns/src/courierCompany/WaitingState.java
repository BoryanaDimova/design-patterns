package courierCompany;

public class WaitingState implements State {

	private String stateName = "Waiting";
	
	@Override
	public void applyState(Observable employee) {
		employee.setState(this);

	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return stateName;
	}
}
