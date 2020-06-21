package courierCompany;

public class PreparationState implements State {

	private String stateName = "In Preparation";
	
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
