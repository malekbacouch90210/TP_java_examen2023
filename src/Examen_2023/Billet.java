package Examen_2023;

import java.time.LocalDate;

public class Billet implements Publiable{
	private LocalDate datePub;
	private String auteur;
	
	public Billet(LocalDate datePub, String auteur) {
		this.datePub=datePub;
		this.auteur=auteur;
	}
	
	

	@Override
	public String toString() {
		return "Billet [datePub=" + datePub + ", auteur=" + auteur + "]";
	}



	@Override
	public LocalDate getDatePublication() {
		return datePub;
	}

	@Override
	public String getAuteur() {
		return auteur;
	}
	

}
