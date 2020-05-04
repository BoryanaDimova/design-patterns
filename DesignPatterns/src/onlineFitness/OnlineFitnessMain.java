package onlineFitness;

public class OnlineFitnessMain {

	public static void main(String[] args) {
		FitnessInstructor fitnessInstructor = new FitnessInstructor();
		Trainee trainee = new Trainee();
		
		Spectator spectator1 = new Spectator("Spectator 1");
		Spectator spectator2 = new Spectator("Spectator 2");
		Spectator spectator3 = new Spectator("Spectator 3");
		
		Spectator spectator4 = new Spectator("Spectator 4");
		spectator4.setTrainee(trainee);
		spectator4.update();
		
		trainee.registerSpectator(spectator1);
		trainee.registerSpectator(spectator2);
		trainee.registerSpectator(spectator3);
		
		Instruction standUpCommand = new StandUpCommand(trainee);
		Instruction lieDownCommand = new LieDownCommand(trainee);
		
		Runnable myRunnable = new Runnable(){ public void run(){} };
		
		Thread thread = new Thread(myRunnable);
		thread.start();
		
		Instruction[] instructions = {lieDownCommand, standUpCommand, lieDownCommand, lieDownCommand, standUpCommand, standUpCommand, standUpCommand, lieDownCommand, standUpCommand};
		
		for(Instruction i : instructions) {
			fitnessInstructor.setCommand(i);
			fitnessInstructor.sayInstruction();
			
			try {
				thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("\r\n The training for today has finished! See you the next time!");
	}
}
