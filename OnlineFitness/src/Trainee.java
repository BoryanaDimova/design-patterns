import java.util.ArrayList;
import java.util.List;

public class Trainee implements Observable{

	private String commandName;
	private List<Observer> specators = new ArrayList<>();
	
	public void standUp() {
		this.changeCommand("Stand Up");
	}
	
	public void lieDown() {
		this.changeCommand("Lie Down");
	}

	@Override
	public void register(Observer observer) {
		specators.add(observer);
		observer.setTrainee(this);
	}

	@Override
	public void unregister(Observer observer) {
		specators.remove(observer);
		observer.setTrainee(null);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs: this.specators) {
			obs.update();
		}	
	}

	@Override
	public Object getUpdate(Observer obs) {
		return this.commandName;
	}
	
	private void changeCommand(String commandName){
		this.commandName = commandName;
		System.out.println("\r\n -> The new exercise for the trainee is: "+ commandName);
		this.notifyObservers();
	}
}
