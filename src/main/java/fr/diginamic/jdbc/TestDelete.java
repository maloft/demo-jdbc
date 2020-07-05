package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

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
        Statement statement = null;
        ResultSet resultSet = null;
        
        
        try {
        	
        	Connection uneConnexion = DriverManager.getConnection(url, user, password);
        	
        	
            // Création d'un statement
            statement = uneConnexion.createStatement();
            
            
            statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID = 4");
            
            
            
    	
    	
        	
        }finally {
	        // Etape 6 - fermer les resssources
	        if(resultSet != null) {
	            resultSet.close();
	        }
	
	        if(statement != null) {
	           statement.close();
	       }
	

        }


	}
}
