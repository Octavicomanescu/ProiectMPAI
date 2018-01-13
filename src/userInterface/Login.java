package userInterface;

/**Clasa Login este folosita pentru a construi interfata cu utilizatorul. In prima instanta utilizatorul vede fereastra
 * de logare, ulterior daca logarea este realizata cu succes , ii este disponibila interfata in care este specificata \
 * starea curenta a zonelor pentru care are acces(pentru care primeste notificari)
 * 
 * Interfata "SmartHome in Java":
 * -O zona in care se arata folosind Design Pattern-ul State si Facade starea actuala a zonelor care denumita "Status Casa"
 * -In partea stanga a textarea-ului "Status Casa" este o zona unde poate modifica dupa alegerea unei zone (in functie de acces)
 *  din comboBox:
 *  Sist Securitate,Curent Electric,Senzor fum,Control Access,Sist Video,Ventilatie,Iluminat, dupa ce o zona este selectata
 *  se apasa butonul Modifica iar acestei zone i se face toggle in functie de starea in care se afla ulterior.
 * -Imediat sub zona "Status casa" se afla zona "Status initial casa" este statusul casei folosind design pattern-ul Observer,
 * 	deasemeni aceasta este construita in functie de zonele la care utilizatorul are acces. In functie de utilizator obiectului 
 * 	de tip Subiect i se adauga in lista de Observers , zona care trebuie monitorizata.
 * - In dreapta zonei "Status casa" se afla asa numita zona "Panou general" unde prin apasarea butonului "Activeaza/Dezaciveaza"
 * 	se schimba stare "On/Off" a tuturor observerilor din lista.
 *  i
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import problema_1.Sensor;
import observerDP.*;

public class Login {
	String autentificat = "";
	String comboVal, comboValObs;
	int indexC;
	String msjObserver = "";
	String labelButtonPG = "";
	Sensor sensor = new Sensor();

	ArrayList<String> strDeafisat = new ArrayList<String>();
	ArrayList<String> strToate = new ArrayList<String>();

	Subiect utilizator = new Subiect();
	SistemSecuritate secSys;
	CurentElectric electric;
	SenzoriDeFum fum;
	ControlAcces cm;
	SistemulVideo sysVid;
	SistemulDeVentilatie vent;
	Iluminatul bec;

	public void LoginScreen() {

		secSys = new SistemSecuritate(utilizator);
		electric = new CurentElectric(utilizator);
		fum = new SenzoriDeFum(utilizator);
		cm = new ControlAcces(utilizator);
		sysVid = new SistemulVideo(utilizator);
		vent = new SistemulDeVentilatie(utilizator);
		bec = new Iluminatul(utilizator);

		JFrame fr = new JFrame("Autentificare");
		fr.setSize(300, 150);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fr.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String user = userText.getText();
				String pass = new String(passwordText.getPassword());

				if ((user.equals("") || user.equals(null)) && (pass.equals("") || pass.equals(null))) {
					JOptionPane.showMessageDialog(fr, "Username-ul si Parola sunt goale");
				} else if ((user.equals("") || user.equals(null))) {
					JOptionPane.showMessageDialog(fr, "Username-ul este gol");
				} else if ((pass.equals("") || pass.equals(null))) {
					JOptionPane.showMessageDialog(fr, "Parola este goala");
				} else {

					fr.setVisible(false);
					fr.dispose();

					autentificat = userAut(user, pass);
					userScreen(autentificat);
				}

			}
		});

		panel.setVisible(true);
		fr.add(panel);
		fr.setVisible(true);

	}

	public String userAut(String user, String parola) {

		String userAllowed = "";
		switch (user.toLowerCase()) {
		case "admin":
			if (parola.toLowerCase().equals("admin")) {
				userAllowed = user.toLowerCase();
			}
			break;
		case "tata":
			if (parola.toLowerCase().equals("tata")) {
				userAllowed = user.toLowerCase();
			}
			break;
		case "mama":
			if (parola.toLowerCase().equals("mama")) {
				userAllowed = user.toLowerCase();
			}
			break;
		case "copil1":
			if (parola.toLowerCase().equals("copil")) {
				userAllowed = user.toLowerCase();
			}
			break;
		default:
			userAllowed = "nepermis";
		}

		return userAllowed;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	public void userScreen(String userAut) {

		JFrame frUser = new JFrame("SmartHome in Java");
		frUser.setSize(620, 550);
		frUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelUser = new JPanel();
		panelUser.setLayout(null);

		JLabel statusHome = new JLabel("Status Casa");
		statusHome.setBounds(10, 10, 80, 25);
		panelUser.add(statusHome);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 30, 320, 200);
		panelUser.add(textArea);

		JLabel modStatusHome = new JLabel("Modifica Status Casa");
		modStatusHome.setBounds(340, 10, 150, 25);
		panelUser.add(modStatusHome);

		JTextArea textAreaMod = new JTextArea();
		textAreaMod.setEditable(false);
		textAreaMod.setBounds(340, 70, 240, 120);
		panelUser.add(textAreaMod);

		JLabel lObserver = new JLabel("Status initial casa");
		lObserver.setBounds(10, 240, 150, 15);
		panelUser.add(lObserver);

		JTextArea textAreaObs = new JTextArea();
		textAreaObs.setEditable(false);
		textAreaObs.setBounds(10, 255, 320, 200);
		panelUser.add(textAreaObs);

		///////////////////////////////////////////////////////////

		String strGeneral = null;

		///////////////////////////////////////////////////////////

		/// Adaugare optiuni in Combobox
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		ArrayList actDisponibile = new ArrayList();

		if (userAut.equals("mama")) {
			actDisponibile.add("Sist Securitate");
		} else if (userAut.equals("admin") || (userAut.equals("tata"))) {
			actDisponibile.add("Sist Securitate");
			actDisponibile.add("Curent Electric");
			actDisponibile.add("Senzor fum");
		}
		actDisponibile.add("Control Access");
		actDisponibile.add("Sist Video");
		actDisponibile.add("Ventilatie");
		actDisponibile.add("Iluminat");

		for (Iterator<String> iterator = actDisponibile.iterator(); iterator.hasNext();) {
			model.addElement(iterator.next());
		}

		JComboBox comboHome = new JComboBox(model);
		comboHome.setBounds(340, 40, 150, 25);
		panelUser.add(comboHome);

		//////
		strToate = listaDeAfisat(userAut);

		//////////////////////
		comboHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboVal = String.valueOf(comboHome.getSelectedItem());
				indexC = comboHome.getSelectedIndex();
				textAreaMod.setText(strToate.get(indexC));

			}

		});

		///////////////// Afisare pt State Design Patter
		strGeneral = iterateAccesZones(strToate);
		textArea.setText(strGeneral);

		/// Mod nou de afisare cu Observer DP

		if (userAut.equals("mama")) {
			utilizator.removeObserver(electric);
			utilizator.removeObserver(fum);
			utilizator.setState("on");
		}
		if (userAut.equals("admin") || userAut.equals("tata")) {
			utilizator.setState("on");
		}

		if (userAut.equals("copil1")) {
			utilizator.removeObserver(secSys);
			utilizator.removeObserver(electric);
			utilizator.removeObserver(fum);
			utilizator.setState("on");
		}

		msjObserver = utilizator.notifyObservers();
		textAreaObs.setText(msjObserver);

		///////////////////////////////////////////////////////////

		JButton editButton = new JButton("Modifica");
		editButton.setBounds(385, 200, 150, 25);
		panelUser.add(editButton);
		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				modifyState(comboVal, indexC, strDeafisat);
				textArea.setText(iterateAccesZones(strToate));
				textAreaMod.setText(strToate.get(indexC));
			}
		});

		JLabel lPanougeneral = new JLabel("Panou General");
		lPanougeneral.setBounds(420, 280, 150, 15);
		panelUser.add(lPanougeneral);
		/*
		 * if(utilizator.getState().equals("on")) { labelButtonPG="Dezactivare sistem";
		 * }else { labelButtonPG="Activare sistem"; }
		 */

		JButton bPanouGen = new JButton("Dezactivare sistem");
		bPanouGen.setBounds(360, 300, 200, 25);
		panelUser.add(bPanouGen);

		JLabel lRemoveObs = new JLabel("Sterge zona");
		lRemoveObs.setBounds(360, 340, 100, 25);
		panelUser.add(lRemoveObs);

		JComboBox comboHomeObs = new JComboBox(model);
		comboHomeObs.setBounds(360, 360, 120, 25);
		panelUser.add(comboHomeObs);

		comboHomeObs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboValObs = String.valueOf(comboHomeObs.getSelectedItem());
			}

		});

		JButton bRemoveObs = new JButton("Sterge");
		bRemoveObs.setBounds(485, 360, 75, 25);
		panelUser.add(bRemoveObs);

		bRemoveObs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				utilizator.removeObserver(removeObs(comboValObs, utilizator));
				msjObserver = "";
				msjObserver = utilizator.notifyObservers();
				textAreaObs.setText(msjObserver);

			}
		});

		bPanouGen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (utilizator.getState().equals("on")) {
					// labelButtonPG="Dezactivare sistem";
					utilizator.setState("off");
					labelButtonPG = "Activare sistem";
				} else {
					// labelButtonPG="Activare sistem";
					utilizator.setState("on");
					labelButtonPG = "Dezactivare sistem";
				}

				bPanouGen.setText(labelButtonPG);
				frUser.revalidate();
				frUser.repaint();
				msjObserver = utilizator.notifyObservers();
				textAreaObs.setText(msjObserver);
			}
		});

		panelUser.setVisible(true);
		frUser.add(panelUser);
		frUser.setVisible(true);

	}

	public String iterateAccesZones(ArrayList<String> lista) {
		String result = "";
		for (Iterator<String> iterator = lista.iterator(); iterator.hasNext();) {
			result = result + iterator.next() + "\n";

		}
		return result;
	}

	public String modifyState(String combobox, int indexCombo, ArrayList<String> lista) {
		String newModifTxtArea = null;
		switch (combobox) {
		case "Sist Securitate":
			modifSecSys(indexCombo, lista);
			break;
		case "Control Access":
			modifControlAcc(indexCombo, lista);
			break;
		case "Sist Video":
			modifCamera(indexCombo, lista);
			break;
		case "Senzor fum":
			modifSenzorFum(indexCombo, lista);
			break;
		case "Curent Electric":
			modifCurrent(indexCombo, lista);
			break;
		case "Ventilatie":
			modifFan(indexCombo, lista);
			break;
		case "Iluminat":
			modifLights(indexCombo, lista);
			break;

		}

		return newModifTxtArea;

	}

	// Modifica sist securitate iteratring teAccesZones(strDeafisat);
	public void modifSecSys(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Sistemul de securitate este activ")) {
			lista.set(comboIndex, sensor.SecurityOff());
		} else if (State.contains("Sistemul de securitate este dezactivat")) {
			lista.set(comboIndex, sensor.SecurityOn());
		}
	}

	public void modifControlAcc(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Usa de la intrare este incuiata")) {
			lista.set(comboIndex, sensor.doorUnlocked());
		} else if (State.contains("Usa de la intrare este descuiata")) {
			lista.set(comboIndex, sensor.doorLocked());
		}
	}

	public void modifCamera(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Sistemul video inregistreaza")) {
			lista.set(comboIndex, sensor.CameraOff());
		} else if (State.contains("Sistemul video nu inregistraza")) {
			lista.set(comboIndex, sensor.CameraOn());
		}
	}

	public void modifSenzorFum(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Senzorul de fum din dormitor este activ")) {
			lista.set(comboIndex, sensor.SenzorFumOff());
		} else if (State.contains("Senzorul de fum din dormitor este inactiv")) {
			lista.set(comboIndex, sensor.SecurityOn());
		}

	}

	public void modifCurrent(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Curentul electric din bucatarie este oprit")) {
			lista.set(comboIndex, sensor.CurrentOn());
		} else if (State.contains("Curentul electric din bucatarie este pornit")) {
			lista.set(comboIndex, sensor.CurrentOff());
		}

	}

	public void modifFan(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Sistemul de ventilatie este setat pe caldura si este pornit")) {
			lista.set(comboIndex, sensor.fanOff());
		} else if (State.contains("Sistemul de ventilatie este setat pe caldura si este oprit")) {
			lista.set(comboIndex, sensor.fanOn());
		}
	}

	public void modifLights(int comboIndex, ArrayList<String> lista) {
		String State = iterateAccesZones(lista);
		if (State.contains("Luminile din living sunt aprinse")) {
			lista.set(comboIndex, sensor.LightsOff());
		} else if (State.contains("Luminile din living sunt stinse")) {
			lista.set(comboIndex, sensor.LightsOn());
		}
	}

	@SuppressWarnings("rawtypes")
	public ArrayList listaDeAfisat(String user) {

		if (user.equals("mama")) {
			strDeafisat.add(sensor.SecurityOn());
		} else if (user.equals("admin") || user.equals("tata")) {
			strDeafisat.add(sensor.SecurityOn());
			strDeafisat.add(sensor.CurrentOn());
			strDeafisat.add(sensor.SenzorFumOn());
		}
		strDeafisat.add(sensor.doorLocked());
		strDeafisat.add(sensor.CameraOn());
		strDeafisat.add(sensor.fanOn());
		strDeafisat.add(sensor.LightsOn());

		return strDeafisat;
	}

	public Observer removeObs(String comboboxObserver, Subiect sub) {
		switch (comboboxObserver) {
		case "Sist Securitate":
			// return new SistemSecuritate(sub);
			return secSys;
		case "Control Access":
			// return new ControlAcces(sub);
			return cm;
		case "Sist Video":
			return sysVid;
		// return new SistemulVideo(sub);
		case "Senzor fum":
			return fum;
		// return new SenzoriDeFum(sub);
		case "Curent Electric":
			return electric;
		// return new CurentElectric(sub);
		case "Ventilatie":
			return vent;
		// return new SistemulDeVentilatie(sub);
		case "Iluminat":
			return bec;
		// return new Iluminatul(sub);
		default:
			return null;

		}

	}

}
