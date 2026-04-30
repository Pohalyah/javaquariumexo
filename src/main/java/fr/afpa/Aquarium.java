package fr.afpa;

import java.util.ArrayList;
import java.util.Random;

import fr.afpa.Poisson.Sexe;
import fr.afpa.TypePoisson.Bar;
import fr.afpa.TypePoisson.Carpe;
import fr.afpa.TypePoisson.Merou;
import fr.afpa.TypePoisson.PoissonClown;
import fr.afpa.TypePoisson.Sole;
import fr.afpa.TypePoisson.Thon;

public class Aquarium {

    int numeroTour = 0;

    String[] tableauDeNomMale = { "Nicolas", "Bob", "Didier", "David", "Jacques", "Camille", "Ludoc", "Vincent",
            "Olvier", "Laurent", "Valentin", "Igor", "Clément" };
    String[] tableauDeNomFemelle = { "Victoria", "Orianna", "Lucie", "Vivianne", "Isabelle", "Camille", "Ludivine",
            "Gabrielle", "Ursula", "Tania", "Elisabeth", "Anissa", "Lisa", "Nadia" };

    Random r = new Random();
    private ArrayList<Poisson> poissons = new ArrayList<>();
    private ArrayList<Poisson> poissonsMorts = new ArrayList<>();
    private ArrayList<Poisson> poissonsMortsTemp = new ArrayList<>();
    private ArrayList<Poisson> poissonsNaissance = new ArrayList<>();

    private ArrayList<Algue> algues = new ArrayList<>();
    private ArrayList<Algue> alguesMortes = new ArrayList<>();
    private ArrayList<Algue> alguesMortesTemp = new ArrayList<>();
    private ArrayList<Algue> alguesNaissance = new ArrayList<>();

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addAlgue(Algue algue) {
        algues.add(algue);
    }

    public Poisson donnerNaissancePoisson(Poisson cePoisson) {
        int sexeRandom = r.nextInt(0, 2);
        Sexe sexePoisson;
        String nomPoisson;
        if (sexeRandom == 0) {
            sexePoisson = Sexe.MALE;
            int nomRandom = r.nextInt(0, tableauDeNomMale.length);
            nomPoisson = tableauDeNomMale[nomRandom];

        } else {
            sexePoisson = Sexe.FEMELLE;
            int nomRandom = r.nextInt(0, tableauDeNomFemelle.length);
            nomPoisson = tableauDeNomFemelle[nomRandom];
        }

        if (cePoisson instanceof Bar) {

            return new Bar(nomPoisson, sexePoisson);
        } else if (cePoisson instanceof Carpe) {

            return new Carpe(nomPoisson, sexePoisson);
        } else if (cePoisson instanceof Merou) {

            return new Merou(nomPoisson, sexePoisson);
        } else if (cePoisson instanceof PoissonClown) {

            return new PoissonClown(nomPoisson, sexePoisson);
        } else if (cePoisson instanceof Sole) {

            return new Sole(nomPoisson, sexePoisson);
        } else if (cePoisson instanceof Thon) {

            return new Thon(nomPoisson, sexePoisson);
        } else {
            throw new IllegalStateException("Erreur.");
        }

    }

    public void reproductionPoisson() {
        poissonsNaissance.clear();
        for (int i = 0; i < poissons.size(); i++) {

            Poisson cePoisson = poissons.get(i);

            int indexPoisson = r.nextInt(0, poissons.size());
            Poisson poissonChoisi = poissons.get(indexPoisson);
            if (cePoisson.getPv() > 5 && cePoisson != poissonChoisi) {
                if (cePoisson.getClass() == poissonChoisi.getClass()
                        && cePoisson.getSexe() != poissonChoisi.getSexe()) {
                    if (cePoisson.getAge() >= 5 && poissonChoisi.getAge() >= 5) {
                        Poisson nouveauBebe = donnerNaissancePoisson(cePoisson);
                        poissonsNaissance.add(nouveauBebe);

                    }

                }
            }
        }
        poissons.addAll(poissonsNaissance);
    }

    public void reproductionAlgue() {
        alguesNaissance.clear();
        for (int i = 0; i < algues.size(); i++) {
            Algue cetAlgue = algues.get(i);

            if (cetAlgue.getPv() >= 10) {
                Algue nouveauAlgue = cetAlgue.seReproduire();
                alguesNaissance.add(nouveauAlgue);
            }
        }
        algues.addAll(alguesNaissance);
    }

    public void mangerUnTruc() {

        for (int i = 0; i < poissons.size(); i++) {
            if (poissons.get(i) instanceof Carnivore cePoisson && poissons.get(i).getPv() <= 5) {

                if (poissons.size() >= 2) {
                    int indexPoisson = r.nextInt(0, poissons.size());
                    Poisson poissonMordu = poissons.get(indexPoisson);

                    if (indexPoisson != i && poissonMordu.getClass() != cePoisson.getClass()) {
                        int randomChance = r.nextInt(0, 2);
                        if (randomChance == 1) {
                            cePoisson.mangerViande(poissonMordu);
                        }
                    }
                }
            }
            if (poissons.get(i) instanceof Herbivore cePoisson && poissons.get(i).getPv() <= 5) {
                if (algues.size() >= 1) {
                    int indexAlgue = r.nextInt(0, algues.size());
                    Algue algueMordu = algues.get(indexAlgue);

                    cePoisson.mangerAlgue(algueMordu);

                }
            }
        }
    }

    public void deleteMortsPoissons() {
        Poisson temp;
        poissonsMortsTemp.clear();
        for (int i = 0; i < poissons.size(); i++) {
            if (poissons.get(i).estMort()) {
                temp = poissons.get(i);
                poissonsMortsTemp.add(temp);
            }
        }
        poissonsMorts.addAll(poissonsMortsTemp);
        poissons.removeAll(poissonsMortsTemp);
    }

    public void deleteMortsAlgues() {
        Algue temp;
        alguesMortesTemp.clear();
        for (int i = 0; i < algues.size(); i++) {
            if (algues.get(i).estMort()) {
                temp = algues.get(i);
                alguesMortesTemp.add(temp);
            }
        }
        alguesMortes.addAll(alguesMortesTemp);
        algues.removeAll(alguesMortesTemp);
    }

    public boolean isEmpty() {
        if (poissons.size() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void jouerTour() {

        System.out.println(numeroTour + 1);

        for (int i = 0; i < poissons.size(); i++) {
            poissons.get(i).vivreUnTour();
        }
        for (int i = 0; i < algues.size(); i++) {
            algues.get(i).vivreUnTour();
        }

        deleteMortsAlgues();
        deleteMortsPoissons();

        mangerUnTruc();

        deleteMortsAlgues();
        deleteMortsPoissons();

        System.out.println(this.toString());

        numeroTour++;
    }

    @Override
    public String toString() {

        StringBuilder texte = new StringBuilder();

        // --- PLANTES ---
        texte.append("Nombre de plante : ")
                .append(algues.size())
                .append("\n");

        texte.append("Liste de plante :\n");

        for (int i = 0; i < algues.size(); i++) {
            texte.append("- ")
                    .append(algues.get(i))
                    .append("\n");
        }

        texte.append("\n"); // séparation

        // --- POISSONS ---
        texte.append("Nombre de poisson : ")
                .append(poissons.size())
                .append("\n");

        texte.append("Liste de poisson :\n");

        for (int i = 0; i < poissons.size(); i++) {
            texte.append("- ")
                    .append(poissons.get(i))
                    .append("\n");
        }

        return texte.toString();
    }
}
