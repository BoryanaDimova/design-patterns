package onlineFitness;

public class StandUpCommand implements Instruction{

	private Trainee trainee;
	
	public StandUpCommand(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public void execute() {
		this.trainee.standUp();
	}
}
