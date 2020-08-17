package Database;

import Bedrijf.Bestelling;
import Bedrijf.Status;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BestellingDao extends BaseDao {

    public void save(Bestelling bestelling) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Bestellingen(Klantennummer, Postcode, Grootte, Status_Bestelling, Priority) VALUES(?,?,?,?,?)");

            ps.setInt(1, bestelling.getKlantennummer());
            ps.setInt(2, bestelling.getPostcode());
            ps.setInt(3, bestelling.getGrootte());
            ps.setString(4,String.valueOf(bestelling.getStatus()));
            ps.setBoolean(5, bestelling.getPrior());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bestelling> getallBestellingen(int klantennummer) {
        ArrayList<Bestelling> bestellingen = new ArrayList<>();

        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Bestellingen WHERE klantennummer=?");
            ps.setInt(1, klantennummer);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bestellingen.add(new Bestelling(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), Status.valueOf(rs.getString(5)), rs.getBoolean(7), LocalDate.parse(rs.getString(6))));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bestellingen;
    }
}





