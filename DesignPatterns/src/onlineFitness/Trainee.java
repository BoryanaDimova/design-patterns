package onlineFitness;
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
	public void registerSpectator(Observer spectator) {
		specators.add(spectator);
		spectator.setTrainee(this);
	}

	@Override
	public void unregisterSpectator(Observer spectator) {
		specators.remove(spectator);
		spectator.setTrainee(null);
	}

	@Override
	public void notifySpectators() {
		for (Observer spectator: this.specators) {
			spectator.update();
		}	
	}

	@Override
	public Object getUpdate(Observer spectator) {
		if(!specators.contains(spectator)) {
			System.out.println("The spectator is not allowed to get the leatest changes!!!");
			return null;
		}
		return this.commandName;
	}
	
	private void changeCommand(String commandName){
		
		if(commandName.equals(this.commandName)) {
			System.out.println("\r\n -> The command is not changed: "+ commandName);
			// there is no need to change the command and to notify the spectators, because the command is the same as the previous
			return; 
		}
		this.commandName = commandName;
		System.out.println("\r\n -> The new exercise for the trainee is: "+ commandName);
		this.notifySpectators();
	}
}
