package fr.diginamic.jdbc;


import fr.diginamic.entites.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {

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
            
            
            ArrayList<Fournisseur> resultList = new ArrayList<>();
            
            //une requête qui permet d’extraire la liste de tous les fournisseurs.
            ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");
            boolean current = curseur.next();
            while (current)
            {
            	Fournisseur f = new Fournisseur();
            	f.setID(curseur.getInt("ID"));
            	f.setNOM(curseur.getString("NOM"));
            	resultList.add(f);
            	current = curseur.next();
            	
            }
            
            
           for (int i = 0; i<resultList.size(); i++)
           {
        	   System.out.println(resultList.get(i));
           }
            
            
	       if(curseur != null) {
	    	   curseur.close();
	       }
            
            
            
            
    	
    	
        	
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
