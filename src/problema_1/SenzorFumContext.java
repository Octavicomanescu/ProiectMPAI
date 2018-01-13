package problema_1;

public class SenzorFumContext implements State {

	private String name;
	private State senFumState;

	public SenzorFumContext(String locatie) {
		this.name = locatie;
	}

	public void setState(State st) {
		this.senFumState = st;
	}

	public State getState() {
		return this.senFumState;
	}

	@Override
	public String doAction() {
		String msg;
		// System.out.print("Senzorul de fum din "+name+" este ");
		msg = "Senzorul de fum din " + name + " este " + this.senFumState.doAction();
		return msg;
	}

}
