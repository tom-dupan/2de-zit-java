package Database;


import Bedrijf.Gebruiker;

import java.sql.*;
import java.util.ArrayList;

public class KlantDao extends BaseDao{

    private ArrayList<String>klanten = new ArrayList<>();

    public void save(Gebruiker klant){
        try (Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO Klanten VALUES(?,?,?)");
            ps.setString(1, null);
            ps.setString(2,klant.getNaam());
            ps.setString(3,klant.getAdres());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getallnames(){
        try (Connection c = getConnection()){
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("Select * FROM Klanten");

            while(rs.next()){
                klanten.add(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return klanten;
    }

}



