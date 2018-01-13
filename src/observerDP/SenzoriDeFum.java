package observerDP;

public class SenzoriDeFum extends Observer {

	public SenzoriDeFum(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Sistemul detectie incendiu este " + subject.getState());
		return "Sistemul detectie incendiu este " + subject.getState();
	}

}
