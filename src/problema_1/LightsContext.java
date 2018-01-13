package problema_1;

public class LightsContext implements State {

	private String name;
	private State lights;

	public LightsContext(String locatie) {
		this.name = locatie;
	}

	public void setState(State st) {
		this.lights = st;
	}

	public State getState() {
		return this.lights;
	}

	@Override
	public String doAction() {
		String msg;
		// System.out.print("Luminile din "+name+" sunt ");
		msg = "Luminile din " + name + " sunt " + this.lights.doAction();
		return msg;

	}

}
