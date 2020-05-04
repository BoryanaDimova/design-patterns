package onlineFitness;

public class Spectator implements Observer{

	private String name;
	private Observable trainee;
	
	public Spectator(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(trainee == null) {
			System.out.println("\t" + this.name + " has no trainee! ");
			return;
		}
		
			String message = (String) this.trainee.getUpdate(this);
			
		if(message == null) {
			System.out.println("\t =>>>" + this.name + " cannot be updated. ");
			return;
		}
			
		System.out.println("\t =>>> Observer: " + this.name + " has been updated. " 
		+ "The new instruction is: " + message);
	}

	@Override
	public void setTrainee(Observable trainee) {
		this.trainee = trainee;
	}

}
