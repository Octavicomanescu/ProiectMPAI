package observerDP;

public class SistemulDeVentilatie extends Observer {

	public SistemulDeVentilatie(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Sistemul de ventilatie este " + subject.getState());
		return "Sistemul de ventilatie este " + subject.getState();
	}

}
