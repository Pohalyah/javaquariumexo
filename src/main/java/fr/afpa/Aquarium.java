package fr.afpa;

import java.util.ArrayList;

public class Aquarium {
    private ArrayList<Poisson> poissons = new ArrayList<>();
    private ArrayList<Algue> plantes = new ArrayList<>();

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addPlante(Algue plante) {
        plantes.add(plante);
    }

    @Override
    public String toString() {

        StringBuilder texte = new StringBuilder();

        // --- PLANTES ---
        texte.append("Nombre de plante : ")
                .append(plantes.size())
                .append("\n");

        texte.append("Liste de plante :\n");

        for (int i = 0; i < plantes.size(); i++) {
            texte.append("- ")
                    .append(plantes.get(i))
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
