package observerDP;

public class SistemSecuritate extends Observer {

	public SistemSecuritate(Subiect sub) {

		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Sistemul de securitate este " + subject.getState());
		return "Sistemul de securitate este " + subject.getState();
	}

}
