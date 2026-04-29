package fr.afpa;

import java.util.ArrayList;
import java.util.Random;

public class Aquarium {
    Random r = new Random();
    private ArrayList<Poisson> poissons = new ArrayList<>();
    private ArrayList<Algue> algues = new ArrayList<>();

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addPlante(Algue plante) {
        algues.add(plante);
    }

    public void mangerUnTruc() {

        for (int i = 0; i < poissons.size(); i++) {
            if (poissons.get(i) instanceof Carnivore cePoisson) {

                if (poissons.size() >= 2) {
                    int indexPoisson = r.nextInt(0, poissons.size());
                    Poisson poissonMordu = poissons.get(indexPoisson);
                    if (indexPoisson != i) {
                        cePoisson.mangerViande(poissonMordu);
                    }
                }
            }
            if (poissons.get(i) instanceof Herbivore cePoisson) {
                if (algues.size() >= 1) {
                    int indexAlgue = r.nextInt(0, algues.size());
                    Algue algueMordu = algues.get(indexAlgue);

                    cePoisson.mangerAlgue(algueMordu);

                }
            }
        }
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
