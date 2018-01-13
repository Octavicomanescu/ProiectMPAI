package observerDP;

import java.util.List;
import java.util.ArrayList;

public class Subiect {

	private List<Observer> observers = new ArrayList<>();
	private String state;
	public String msjObserver = "";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}

	public void addObserver(Observer obs) {

		observers.add(obs);
	}

	public void removeObserver(Observer obs) {

		observers.remove(obs);
	}

	public String notifyObservers() {
		String temp = "";
		for (Observer observer : observers) {
			// observer.update();
			// msjObserver=msjObserver+observer.update()+"\n";
			temp = temp + observer.update() + "\n";
		}
		msjObserver = temp;
		return msjObserver;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return observers.toString();
	}

}
