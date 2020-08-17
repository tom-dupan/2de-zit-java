package Frame;

import Bedrijf.Bestelling;
import Bedrijf.Status;
import Database.BestellingDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddBestelling extends JFrame {

	private JTextField text1, text2;
	private JButton addBestelling, showBestelling;
	private JTextPane bestellingen = new JTextPane();

	public AddBestelling() {
		this.setLayout(new GridLayout(3,2));
		this.add(getText1());
		this.add(getText2());
		this.add(getShowBestelling());
		this.add(getAddBestelling());
		this.add(getBestellingen());

		this.pack();
		this.setVisible(true);
	}
	public JTextField getText1() {
		if (text1 == null) {
			text1 = new JTextField();
			text1.setText("Enter klantennummer...");
		}

		return text1;
	}

		public JTextField getText2() {
		if(text2 == null) {
			text2 = new JTextField();
			text2.setText("Enter postcode...");
		}

		return text2;
	}

	public void updateBestellingen(int klantennummer) {
		BestellingDao bestellingDao = new BestellingDao();
		bestellingen.setText("");
		for(Bestelling b : bestellingDao.getallBestellingen(klantennummer)) {
			bestellingen.setText(bestellingen.getText() + (bestellingen.getText().equals("") ? "":"\n") + b);
		}
	}

	public JButton getAddBestelling() {
		if(addBestelling == null) {
			addBestelling = new JButton("Maak bestelling");
			addBestelling.addActionListener(new ActionListener() {
				private Object Bestelling;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {

					if (text1.getText().trim().equals("") ||text2.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(getAddBestelling(), "Je postcode moet ingevuld zijn!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							FileOutputStream out = new FileOutputStream("file2.txt");
						BestellingDao bDao = new BestellingDao();
						bDao.save(new Bestelling(Integer.parseInt(getText1().getText()), Integer.parseInt(getText2().getText()), true, Status.AT_DEPOT));
						updateBestellingen(Integer.parseInt(getText2().getText()));

						out.write((byte[]) Bestelling);

						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}
			});
		}
		return addBestelling;
	}

	public JTextPane getBestellingen() {
		if(bestellingen == null) {
			bestellingen = new JTextPane();
		}

		return bestellingen;
	}

	public JButton getShowBestelling() {
		if(showBestelling == null) {
			showBestelling = new JButton("Toon bestellingen");
			showBestelling.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					if(text1.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(getAddBestelling(), "Je klantennummer moet ingevuld zijn!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						updateBestellingen(Integer.parseInt(text1.getText()));
					}
				}
			});
		}

		return showBestelling;
	}
}
