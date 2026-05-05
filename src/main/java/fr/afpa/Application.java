package fr.afpa;

import java.util.Scanner;

import fr.afpa.Poisson.Sexe;
import fr.afpa.TypePoisson.Merou;
import fr.afpa.TypePoisson.PoissonClown;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        while (!aquarium1.isEmpty()) {

            System.out.println("D = Démarrer simulation");
            System.out.println("T = Tour suivant");
            System.out.println("S = Sauvegarder");
            System.out.println("C = Charger sauvegarde");
            System.out.println("Q = Sauvegarder et quitter partie");

            String inputUser = scanner.nextLine();

            if ("T".equals(inputUser)) {
                aquarium1.jouerTour();

            } else if ("S".equals(inputUser)) {
                aquarium1.sauvegarder("save.poisson");

            } else if ("C".equals(inputUser)) {
                aquarium1 = Aquarium.charger("save.poisson");

            } else if ("Q".equals(inputUser)) {
                aquarium1.sauvegarder("save.poisson");
                break;

            }

        }

    }
}
