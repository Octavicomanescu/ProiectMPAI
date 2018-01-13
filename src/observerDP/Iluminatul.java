package observerDP;

public class Iluminatul extends Observer {

	public Iluminatul(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Iluminatul este " + subject.getState());
		return "Iluminatul este " + subject.getState();
	}

}
