
public class OnlineFitnessMain {

	public static void main(String[] args) {
		FitnessInstructor fitnessInstructor = new FitnessInstructor();
		Trainee trainee = new Trainee();
		
		Spectator spectator1 = new Spectator("Spectator 1");
		Spectator spectator2 = new Spectator("Spectator 2");
		Spectator spectator3 = new Spectator("Spectator 3");
		
		trainee.register(spectator1);
		trainee.register(spectator2);
		trainee.register(spectator3);
		
		StandUpCommand standUpCommand = new StandUpCommand(trainee);
		LieDownCommand lieDownCommand = new LieDownCommand(trainee);
		
		Thread tread = new Thread();
		fitnessInstructor.setCommand(standUpCommand);
		fitnessInstructor.sayInstruction();
		
		fitnessInstructor.setCommand(lieDownCommand);
		fitnessInstructor.sayInstruction();
		
		
		fitnessInstructor.setCommand(standUpCommand);
		fitnessInstructor.sayInstruction();

		fitnessInstructor.setCommand(lieDownCommand);
		fitnessInstructor.sayInstruction();

		fitnessInstructor.setCommand(standUpCommand);
		fitnessInstructor.sayInstruction();
	}

}
