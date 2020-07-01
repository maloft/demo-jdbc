package fr.diginamic.jvm;

import java.util.ArrayList;

public class TestMemoire {

	public static void main(String[] args) {
		
		ArrayList<String> listeString = new ArrayList<String>();
		boolean arret = false;
		int i = 1;
		
		while ( !arret ) {
			listeString.add("k");
			
			if (i % 10000 == 0) {
				System.out.println(listeString.size());
			}
			
			i++;
		}

		
		/*Quand on compile avec Xmx100k on obtient l'erreur suivante : 
		 * Error occurred during initialization of VM
		 * Too small maximum heap
		 */
	}

}
