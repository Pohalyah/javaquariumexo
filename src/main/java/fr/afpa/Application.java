package fr.afpa;

import fr.afpa.Poisson.Sexe;
import fr.afpa.TypePoisson.Merou;
import fr.afpa.TypePoisson.PoissonClown;

public class Application {

    public static void main(String[] args) {

        boolean partieTerminee = false;
        Aquarium aquarium1 = new Aquarium();

        Poisson poisson1 = new Merou("Jacobus", Sexe.MALE);
        Poisson poisson2 = new PoissonClown("Jerome", Sexe.MALE);
        Poisson poisson3 = new Merou("Adrien", Sexe.MALE);
        Poisson poisson4 = new PoissonClown("Maxime", Sexe.MALE);
        Poisson poisson5 = new PoissonClown("Ludovic", Sexe.MALE);
        Poisson poisson6 = new PoissonClown("Pedro", Sexe.MALE);
        Poisson poisson7 = new PoissonClown("Anissa", Sexe.FEMELLE);
        Poisson poisson8 = new PoissonClown("Tabata", Sexe.FEMELLE);
        Poisson poisson9 = new PoissonClown("Lissandra", Sexe.FEMELLE);
        Poisson poisson10 = new PoissonClown("Sona", Sexe.FEMELLE);

        Algue algue1 = new Algue();
        Algue algue2 = new Algue();
        Algue algue3 = new Algue();
        Algue algue4 = new Algue();
        Algue algue5 = new Algue();
        Algue algue6 = new Algue();
        Algue algue7 = new Algue();
        Algue algue8 = new Algue();

        aquarium1.addPoisson(poisson1);
        aquarium1.addPoisson(poisson2);
        aquarium1.addPoisson(poisson3);
        aquarium1.addPoisson(poisson4);
        aquarium1.addPoisson(poisson5);
        aquarium1.addPoisson(poisson6);
        aquarium1.addPoisson(poisson7);
        aquarium1.addPoisson(poisson8);
        aquarium1.addPoisson(poisson9);
        aquarium1.addPoisson(poisson10);
        aquarium1.addAlgue(algue1);
        aquarium1.addAlgue(algue2);
        aquarium1.addAlgue(algue3);
        aquarium1.addAlgue(algue4);
        aquarium1.addAlgue(algue5);
        aquarium1.addAlgue(algue6);
        aquarium1.addAlgue(algue7);
        aquarium1.addAlgue(algue8);

        for (int i = 0; i < 5; i++) {
            aquarium1.jouerTour();

        }

    }
}
