package Frame;

import Bedrijf.Bestelling;
import Bedrijf.Gebruiker;
import Database.BestellingDao;
import Database.GebruikersDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InlogFrame extends JFrame {
    private JTextField naam, paswoord;
    private JButton register, login;
    private JTextPane bericht = new JTextPane();

    public InlogFrame(){

        this.setLayout(new GridLayout(3,2));
        this.add(getText1());
        this.add(getText2());
        this.add(getShowGebruiker());
        this.add(getAddGebruiker());
        this.add(getGebruiker());

        this.pack();
        this.setVisible(true);

    }
    public JTextField getText1() {
        if(naam == null) {
            naam = new JTextField();
            naam.setText("Enter naam...");
        }

        return naam;
    }

    public JTextField getText2() {
        if (paswoord == null) {
            paswoord = new JTextField();
            paswoord.setText("Enter paswoord...");
        }
        return paswoord;
    }
    public void updateklanten(String naam) {
        GebruikersDao gebruikersDao = new GebruikersDao();
        bericht.setText("");
        for(Gebruiker g : gebruikersDao.login("tom","test")) {
            bericht.setText(bericht.getText() + (bericht.getText().equals("") ? "":"\n") + g);
        }
    }

    public JButton getAddGebruiker() {
        if(register == null) {
            register = new JButton("Maak Gebruiker aan");
            register.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    if(naam.getText().trim().equals("") || paswoord.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(getAddGebruiker(), "Je naam en paswoord moet ingevuld zijn!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        GebruikersDao gDao = new GebruikersDao();
                        gDao.register(new Gebruiker(Integer.parseInt(null),"test","test1"));
                        updateklanten(naam.getText());
                    }
                }
            });
        }
        return register;
    }

    public JTextPane getGebruiker() {
        if(bericht == null) {
            bericht = new JTextPane();
        }

        return bericht;
    }

    public JButton getShowGebruiker() {
        if(login == null) {
            login = new JButton("Toon Gebruiker");
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(naam.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(getAddGebruiker(), "Je naam moet ingevuld zijn!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        updateklanten(naam.getText());
                    }
                }
            });
        }

        return login;
    }
}
