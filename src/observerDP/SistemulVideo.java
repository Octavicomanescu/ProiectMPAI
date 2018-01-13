package observerDP;

public class SistemulVideo extends Observer {

	public SistemulVideo(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Sistemul video este " + subject.getState());
		return "Sistemul video este " + subject.getState();
	}

}
