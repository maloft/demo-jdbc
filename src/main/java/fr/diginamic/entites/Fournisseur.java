package fr.diginamic.entites;

public class Fournisseur {
	
	
	private int ID;
	private String NOM;
	
	
	public Fournisseur() {
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Fournisseur [ID=" + ID + ", NOM=" + NOM + "]";
	}




	//Getters and Setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	
	
	
	
}
