package fr.afpa;

import fr.afpa.Poisson.Sexe;
import fr.afpa.TypePoisson.Merou;

public class Application {

    public static void main(String[] args) {
        Aquarium aquarium1 = new Aquarium();

        Poisson poisson1 = new Merou("Jacobus", Sexe.MALE);

        aquarium1.addPoisson(poisson1);

        System.out.println(aquarium1);

    }
}
