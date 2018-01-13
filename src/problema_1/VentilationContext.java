package problema_1;

public class VentilationContext implements State {

	private State acState;
	private String name;

	public VentilationContext(String nume) {
		this.name = nume;
	}

	public void setState(State st) {
		this.acState = st;
	}

	public State getState() {
		return this.acState;
	}

	@Override
	public String doAction() {
		// TODO Auto-generated method stub
		String msg = "Sistemul de ventilatie este setat pe " + name + " si este " + this.acState.doAction();
		// System.out.print("Sistemul de ventilatie este setat pe "+name+" si este ");
		return msg;
	}

}
