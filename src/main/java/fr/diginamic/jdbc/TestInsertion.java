package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

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
        
     // Création d'un statement
        statement = uneConnexion.createStatement();


       int nbLignesImpactees = statement.executeUpdate
    		   ("insert into FOURNISSEUR(ID, NOM) values(4, 'La Maison de la Peinture')");


	}

}
