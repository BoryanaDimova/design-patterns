
public class Spectator implements Observer{

	private String name;
	private Observable trainee;
	
	public Spectator(String name) {
		this.name = name;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
			String message = (String) this.trainee.getUpdate(this);
		
		System.out.println("\t =>>> Observer: " + this.name + " has been updated. " 
		+ "The new instruction is: " + message);
	}

	@Override
	public void setTrainee(Observable trainee) {
		this.trainee = trainee;
	}

}
