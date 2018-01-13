package problema_1;

public class SysVideoContext implements State {
	// private String name;
	private State videoState;

	public void setState(State st) {
		this.videoState = st;
	}

	public State getState() {
		return this.videoState;
	}

	@Override
	public String doAction() {
		String msg = "Sistemul video " + this.videoState.doAction();
		// System.out.print("Camera din "+name+" ");
		return msg;
	}

}
