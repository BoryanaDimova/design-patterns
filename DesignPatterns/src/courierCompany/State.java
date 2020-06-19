package courierCompany;

public interface State {
	public void applyState(Employee employee);
	public String getStateName();
}
