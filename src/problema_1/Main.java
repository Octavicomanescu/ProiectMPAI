package problema_1;

import userInterface.*;

/**
 * Proiect MPAI
 * Comanescu Octavian grupa 1091 
 * 
 * 
 * Sa se implementeze un proiect Java care sa respecte doua dintre seturile de
 * specificatii de mai jos, tema fiind la alegere. Proiectul se realizeaza în
 * echipe de 2-3 membri. Proiectul va include setul de modele de proiectare
 * specificat. Implementarile care nu contin modelele specificate sunt
 * depunctate (1.5 puncte/model). 1. Se implementeaza functionarea unei case
 * inteligente. Comportamentul casei este reprezentat print-un set de stari.
 * Casa poate sa notifice o serie de utilizatori despre evenimente care apar pe
 * parcursul functionarii, utilizatori care se inregistreaza explicit pentru
 * primirea de notificari. Utilizatorii pot trimite comenzi casei pe baza unui
 * set de fatade în functie de tipul utilizatorului. (State, Observer, Facade)
 * 
 * Logarea in aplicatie se poate face utilizand urmatoarele combinatii(nu sunt
 * case sensitive): User:admin Parola:admin User:tata Parola:tata User:mama
 * Parola:mama User:copil1 Parola:copil1
 *
 * In main se instantiaza clasa Login cu metoda LoginScreen()
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Login log = new Login();

		log.LoginScreen();

	}

}
