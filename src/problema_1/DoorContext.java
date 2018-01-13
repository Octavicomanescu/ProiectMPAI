package problema_1;

public class DoorContext implements State {
	private State doorState;
	public String name;

	public DoorContext(String name) {
		this.name = name;
	}

	public void setState(State state) {
		this.doorState = state;
	}

	public State getState() {
		return this.doorState;
	}

	@Override
	public String doAction() {
		String msg;
		msg = "Usa de la " + name + " este " + this.doorState.doAction();
		// System.out.print("Usa de la " + name + " este ");
		return msg;

	}

}
