package fr.diginamic.connexion;

import java.sql.*;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
		// Lecture du fichier de propriétés
        ResourceBundle database = ResourceBundle.getBundle("database");

        // Etape 1 - Enregistrer le pilote
        DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        Class.forName(database.getString("database.driver"));

        // Etape 2 - Créer une connexion
        
        String url = database.getString("database.url"); 
        String user = database.getString("database.user");
        String password =  database.getString("database.password");
        Connection uneConnexion = DriverManager.getConnection(url, user, password);
        Statement statement = null;
        ResultSet resultSet = null;
        
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);


	}

}
