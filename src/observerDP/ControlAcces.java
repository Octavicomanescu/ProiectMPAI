package observerDP;

public class ControlAcces extends Observer {

	public ControlAcces(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Sistemul de control acces este " + subject.getState());
		return "Sistemul de control acces este " + subject.getState();
	}

}
