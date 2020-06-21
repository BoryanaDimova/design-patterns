package courierCompany;

public interface State {
	public void applyState(Observable employee);
	public String getStateName();
}
