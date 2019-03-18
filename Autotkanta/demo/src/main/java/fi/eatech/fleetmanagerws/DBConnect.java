package fi.eatech.fleetmanagerws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DBConnect{  
	
	
	/**
	 * Tällä metodilla otetaan yhteys tietokantaan. Tässä tapauksessa yhteys otetaan lokaaliin MySql tietokantaan.
	 * @return
	 */
	public static Connection ConnectDB(){

        String url = "jdbc:mysql://localhost:3306/cars2";
        String username = "root";
        String password = "admin";

        System.out.println("Connecting database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
      //connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }        
    }
	
	/**
	 * Tällä metodilla tulostetaan kaikkien autojen tiedot tietokannasta.
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> get() throws Exception{
		try {
			Connection conn = ConnectDB();
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM autot");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("malli"));
				System.out.print(" ");
				System.out.print(result.getString("merkki"));
				System.out.print(" ");
				System.out.print(result.getString("rekisteri"));
				System.out.print(" ");
				System.out.print(result.getString("vuosimalli"));
				System.out.print(" ");
				System.out.print(result.getString("katpvm"));
				System.out.print(" ");
				System.out.print(result.getString("mottil"));
				System.out.print(" ");
				System.out.print(result.getString("motteh"));
				System.out.println();
				
				array.add(result.getString("motteh"));
			}
			System.out.println("All records have been selected!");
			return array;
			
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	/**
	 * Haku metodi tietokannasta.
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> select() throws Exception{
		Connection conn = ConnectDB();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM autot WHERE merkki = 'Hyundai'");
		
		ResultSet result = statement.executeQuery();
		ArrayList<String> array = new ArrayList<String>();
		while(result.next()) {
			array.add(result.getString("malli"));
			array.add(result.getString("merkki"));
			array.add(result.getString("rekisteri"));
			array.add(result.getString("vuosimalli"));
			array.add(result.getString("katpvm"));
			array.add(result.getString("mottil"));
			array.add(result.getString("motteh"));
			
		}
		return array;
	}
	
	/**
	 * Metodi jonka avulla lisätään auto tietokantaan.
	 * @param a auton malli
	 * @param b auton merkki
	 * @param c rekisteri numero
	 * @param d vuosimalli
	 * @param e auton katsastus päivämäärä
	 * @param f auton moottorin tilavuus
	 * @param g auton moottorin teho
	 */
	public static void insert(String a, String b, String c, String d, String e, String f, String g ) {
		String malli, merkki, rekisteri, vuosimalli, katpvm, mottil, motteh;
		malli = a;
		merkki = b;
		rekisteri = c;
		vuosimalli = d;
		katpvm = e;
		mottil = f;
		motteh = g;
		
		Connection conn=ConnectDB();
        try{
            String query = "insert into autot(malli, merkki, rekisteri, vuosimalli, katpvm, mottil, motteh)"
            + " values('"+malli+"', '"+merkki+"', '"+rekisteri+"', '"+vuosimalli+"', '"+katpvm+"', '"+mottil+"','"+motteh+"')";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);


      // execute the preparedstatement
      preparedStmt.execute();
      JOptionPane.showMessageDialog(null, "Data added");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
	}
	
	
	/**
	 * Pääohjelma, jolla kutsutaan metodeja.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception{
		
		
		///insert("S80", "Volvo", "kiipkuups", "2005", "16.08.2374", "300l", "9000kW");
		
		///get();
		
		///ArrayList<String> array = select();
		///for(int i = 0; i < array.size(); i++){
		///System.out.print(array.get(i) + " ");
		
		
		}
	}
	
	
		
}  
