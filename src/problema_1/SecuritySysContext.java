package problema_1;

public class SecuritySysContext implements State {

	private State secSysState;

	public void setState(State st) {
		this.secSysState = st;
	}

	public State getState() {
		return this.secSysState;
	}

	@Override
	public String doAction() {
		String msg;
		// System.out.print("Sistemul de securitate este ");
		msg = "Sistemul de securitate este " + this.secSysState.doAction();
		return msg;
	}

}
