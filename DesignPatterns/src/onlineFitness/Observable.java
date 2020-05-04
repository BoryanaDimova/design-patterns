package onlineFitness;

public interface Observable {
	public void registerSpectator(Observer spectator);
	public void unregisterSpectator(Observer spectator);
	
	public void notifySpectators();
	
	public Object getUpdate(Observer spectator);
}
