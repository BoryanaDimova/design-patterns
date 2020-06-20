package courierCompany;

public interface Observable {
	public void registerSpectator(Observer spectator);
	public void unregisterSpectator(Observer spectator);
	public void notifySpectators();
	public Object getUpdate();
	public String getName();
	public void setState(State state);
}
