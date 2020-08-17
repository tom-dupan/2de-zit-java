package Database;

import Bedrijf.Gebruiker;

import java.sql.*;
import java.util.ArrayList;

public class GebruikersDao extends BaseDao {

        public void register(Gebruiker gebruiker) {
            try (Connection c = getConnection()) {
                PreparedStatement ps = c.prepareStatement("INSERT INTO Gebruikers VALUES(?,?,?)");

                ps.setString(1,null);
                ps.setString(2, gebruiker.getNaam());
                ps.setString(3, gebruiker.getPaswoord());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Gebruiker> login(String naam, String passwoord) {
            ArrayList<Gebruiker> Gebruiker = new ArrayList<>();

            try (Connection c = getConnection()) {
                PreparedStatement ps = c.prepareStatement("SELECT * FROM Bestellingen WHERE naam=?");
                ps.setString(1, naam);
                ps.setString(2, passwoord);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Gebruiker.add(new Gebruiker(rs.getInt(1),rs.getString(2), rs.getString(3)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return Gebruiker;
        }
}

