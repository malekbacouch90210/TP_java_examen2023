package Examen_2023;

public class Blog {
	private String titre;
    private Publiable[] LBillets;
    private int nbBillets;

    public Blog(String titre, int capacite) {
        this.titre = titre;
        this.LBillets = new Publiable[capacite];
        this.nbBillets = 0;
    }
    public void post(Publiable billet) throws InvalidURLException {
        if (billet instanceof Video) {
            Video video = (Video) billet;
            if (!video.getUrl().startsWith("https")) {
                throw new InvalidURLException("vidéo de url doit utiliser HTTPS");
            }
        }
        if (nbBillets < LBillets.length) {
            LBillets[nbBillets] = billet;
            nbBillets++;
        }
    }
    public int getNombreBilletsTaggables() {
        int count = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof BilletTagglable) {
                count++;
            }
        }
        return count;
    }
    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
        Publiable[] result = new Publiable[nbBillets];
        int count = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof BilletTagglable && LBillets[i].getAuteur().equals(auteur)) {
                result[count++] = LBillets[i];
            }
        }
        Publiable[] filteredResult = new Publiable[count];
        System.arraycopy(result, 0, filteredResult, 0, count);
        return filteredResult;
    }

    public Publiable getPlusRécentBillet() {
        if (nbBillets == 0) {
            return null;
        }
        Publiable recent = LBillets[0];
        for (int i = 1; i < nbBillets; i++) {
            if (LBillets[i].getDatePublication().isAfter(recent.getDatePublication())) {
                recent = LBillets[i];
            }
        }
        return recent;
    }
    public Publiable[] RechercheBilletsParContenu(String[] mots) {
        Publiable[] result = new Publiable[nbBillets];
        int count = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof Message) {
                Message message = (Message) LBillets[i];
                boolean containsAll = true;
                for (String mot : mots) {
                    if (message.getContenu().indexOf(mot) == -1) {
                        containsAll = false;
                        break;
                    }
                }
                if (containsAll) {
                    result[count++] = message;
                }
            }
        }
        Publiable[] filteredResult = new Publiable[count];
        System.arraycopy(result, 0, filteredResult, 0, count);
        return filteredResult;
    }

}
