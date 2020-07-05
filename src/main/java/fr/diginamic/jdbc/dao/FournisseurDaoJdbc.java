package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	
	private List<Fournisseur> fournisseurs = new ArrayList<>();
	
	
	public FournisseurDaoJdbc() {
		fournisseurs.add(new Fournisseur(1, "Française d’Imports"));
		fournisseurs.add(new Fournisseur(2, "FDM SA"));
		fournisseurs.add(new Fournisseur(3, "Dubois & Fils"));
	}
	
	
	
	@Override
	public void insert(Fournisseur fournisseur){
		fournisseurs.add(fournisseur);
	
	}

	@Override
	public List<Fournisseur> extraire(){
		return fournisseurs;
		
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		for (Fournisseur f : fournisseurs) {
			
			if(f.getNOM() == ancienNom)
			{
				f.setNOM(nouveauNom);
			}
		}
		
		return 0;
	}

	
	@Override
	public boolean delete(Fournisseur fournisseur) {
		
		boolean bool = fournisseurs.remove(fournisseur);
		return bool;
	
	}

}
