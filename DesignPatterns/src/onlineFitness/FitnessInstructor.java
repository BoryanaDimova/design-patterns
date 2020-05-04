package onlineFitness;
public class FitnessInstructor {
private Instruction instruction;
	
	public void setCommand(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public void sayInstruction() {
		this.instruction.execute();
	}
}
