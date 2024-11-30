package Examen_2023;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Blog blog = new Blog("MonBlog", 10);
        try {
            Video v1 = new Video(LocalDate.of(2023, 1, 10), "Auteur1", 100, "https://example.com/video1");
            //test mta3 exception
            Video v2 = new Video(LocalDate.of(2023, 2, 5), "Auteur2", 200, "http://example.com/video2");
            Message m1 = new Message(LocalDate.of(2023, 3, 15), "Auteur1", "Bonjour tout le monde");
            Message m2 = new Message(LocalDate.of(2023, 4, 20), "Auteur3", "Bienvenue sur mon blog");

            blog.post(v1);
            blog.post(m1);
            blog.post(m2);
            blog.post(v2);
        } catch (InvalidURLException e) {
            System.out.println(e.getMessage());
        }

        int nbTaggables = blog.getNombreBilletsTaggables();
        System.out.println("Nombre de billets taggables : " + nbTaggables);

        Publiable[] billetsParAuteur = blog.RechercheBilletsTaggablesParAuteur("Auteur1");
        System.out.println("Billets taggables par Auteur1 : " + billetsParAuteur.length);

        Publiable plusRecent = blog.getPlusRécentBillet();
        System.out.println("Billet le plus récent : " + plusRecent);

        String[] mots = {"Bienvenue", "blog"};
        Publiable[] billetsParContenu = blog.RechercheBilletsParContenu(mots);
        System.out.println("Billets contenant tous les mots : " + billetsParContenu.length);
    }
}
