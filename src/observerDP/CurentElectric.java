package observerDP;

public class CurentElectric extends Observer {

	public CurentElectric(Subiect sub) {
		this.subject = sub;
		this.subject.addObserver(this);
	}

	@Override
	public String update() {
		System.out.println("Curentul electric este " + subject.getState());
		return "Curentul electric este " + subject.getState();
	}

}
