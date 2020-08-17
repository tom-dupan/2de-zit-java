
import Bedrijf.Bestelling;
import Bedrijf.Gebruiker;
import Bedrijf.Status;
import Database.BestellingDao;
import Database.GebruikersDao;
import Frame.AddBestelling;
import Frame.InlogFrame;
import javafx.util.converter.ByteStringConverter;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {





	public static void main(String[] args) throws IOException {
	ArrayList<Bestelling>lijstchauffeur = new ArrayList<>();
		ArrayList<Bestelling>lijstinlaaddienst = new ArrayList<>();
		FileOutputStream out2 = new FileOutputStream("lijst inlaaddienst.txt");
		FileOutputStream out = new FileOutputStream("lijstchauffeur.txt");
		Gebruiker k1 = new Gebruiker("bob","test",1,"vogelstraat");
		Gebruiker kk = new Gebruiker("tibo","test",2,"vogelstraat");
		GebruikersDao klantDao = new GebruikersDao();




		Bestelling bestelling = new Bestelling(1,9500,true, Status.AT_DEPOT);
		Bestelling bestelling1 = new Bestelling(1,8500,true, Status.AT_DEPOT);
		Bestelling bestelling2 = new Bestelling(3,1000,true, Status.AT_DEPOT);
		Bestelling bestelling3 = new Bestelling(1,3500,true, Status.AT_DEPOT);
		Bestelling bestelling4 = new Bestelling(3,7000,true, Status.AT_DEPOT);

		lijstchauffeur.add(bestelling);
		lijstchauffeur.add(bestelling1);
		lijstchauffeur.add(bestelling2);
		lijstchauffeur.add(bestelling3);
		lijstchauffeur.add(bestelling4);
		lijstchauffeur.sort(Comparator.comparingInt(Bestelling::getPostcode));

		lijstinlaaddienst.add(bestelling);
		lijstinlaaddienst.add(bestelling1);
		lijstinlaaddienst.add(bestelling2);
		lijstinlaaddienst.add(bestelling3);
		lijstinlaaddienst.add(bestelling4);
		lijstinlaaddienst.sort(Comparator.comparing(Bestelling::getBesteldatum));
// write to byte array
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dout = new DataOutputStream(baos);
		for (Bestelling element : lijstchauffeur) {
			dout.writeUTF(String.valueOf(element));
		}
		byte[] bytes = baos.toByteArray();

		ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		DataOutputStream dout2 = new DataOutputStream(baos2);
		for (Bestelling element2 : lijstinlaaddienst) {
			dout2.writeUTF(String.valueOf(element2));
		}
		byte[] bytes2 = baos2.toByteArray();


// read from byte array
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream in = new DataInputStream(bais);
		while (in.available() > 0) {
			String element = in.readUTF();
			System.out.println("chauffeur");
			System.out.println(element);
			out.write(element.getBytes());
			out.write("\n".getBytes());
		}
		ByteArrayInputStream bais2 = new ByteArrayInputStream(bytes2);
		DataInputStream in2 = new DataInputStream(bais2);
		while (in2.available() > 0) {
			String element2 = in2.readUTF();
			System.out.println("inlaaddienst");
			System.out.println(element2);
			out2.write(element2.getBytes());
			out2.write("\n".getBytes());
		}

		BestellingDao bestellingDao = new BestellingDao();
		bestellingDao.save(bestelling);
		bestellingDao.save(bestelling1);




		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				new InlogFrame();
				new AddBestelling();
			}
		});
	}
}
