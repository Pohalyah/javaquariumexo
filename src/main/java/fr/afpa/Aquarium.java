package fr.afpa;

import java.util.ArrayList;
import java.util.Random;

public class Aquarium {

    int numeroTour = 0;

    Random r = new Random();
    private ArrayList<Poisson> poissons = new ArrayList<>();
    private ArrayList<Poisson> poissonsMorts = new ArrayList<>();
    private ArrayList<Poisson> poissonsMortsTemp = new ArrayList<>();

    private ArrayList<Algue> algues = new ArrayList<>();
    private ArrayList<Algue> alguesMortes = new ArrayList<>();
    private ArrayList<Algue> alguesMortesTemp = new ArrayList<>();

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addAlgue(Algue algue) {
        algues.add(algue);
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
