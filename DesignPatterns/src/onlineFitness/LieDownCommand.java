package onlineFitness;

public class LieDownCommand implements Instruction{

	private Trainee trainee;
	
	public LieDownCommand(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public void execute() {
		this.trainee.lieDown();
	}
}
