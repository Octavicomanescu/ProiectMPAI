package problema_1;

public class CurentElectricContext implements State {

	private String name;
	private State electricState;

	public CurentElectricContext(String locatie) {
		this.name = locatie;
	}

	public void setState(State st) {
		this.electricState = st;
	}

	public State getState() {
		return this.electricState;
	}

	@Override
	public String doAction() {
		String msg;
		// System.out.print("Curentul electric din "+name+" este ");
		msg = "Curentul electric din " + name + " este " + this.electricState.doAction();
		return msg;

	}

}
