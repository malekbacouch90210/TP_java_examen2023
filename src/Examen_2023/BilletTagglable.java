package Examen_2023;

import java.time.LocalDate;
import java.util.Arrays;

public class BilletTagglable extends Billet implements Tagglable {
	
	private String[] LTags;
	private int nbTags;

	

	public BilletTagglable(LocalDate datePub, String auteur, int capacité) {
		// TODO Auto-generated constructor stub
		super(datePub, auteur);
		LTags=new String[capacité];
		this.nbTags=0;
	}

	@Override
	public String toString() {
		return "BilletTagglable [LTags=" + Arrays.toString(LTags) + ", nbTags=" + nbTags + ", toString()="+ super.toString() + "]";
	}

	@Override
	public void ajoutTag(String tag) {
		 if (nbTags < LTags.length && rechercheTag(tag) == -1) {
	            LTags[nbTags] = tag;
	            nbTags++;
	      }
	}

	@Override
	public void supprimeTag(String tag) {
		int i = rechercheTag(tag);
        if (i != -1) {
            LTags[i] = LTags[nbTags - 1];
            LTags[nbTags - 1] = null;
            nbTags--;
        }
		
	}

	@Override
	public int nombreTags() {
		return  nbTags;
	}

	@Override
	public int rechercheTag(String tag) {
		for (int i = 0; i < nbTags; i++) {
            if (LTags[i].equals(tag)) {
                return i;
            }
        }
        return -1;
	}

}
