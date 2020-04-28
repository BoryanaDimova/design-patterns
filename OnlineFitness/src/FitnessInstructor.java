public class FitnessInstructor {
private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void sayInstruction() {
		this.command.execute();
	}
}
