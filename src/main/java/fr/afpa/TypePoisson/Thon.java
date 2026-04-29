package fr.afpa.TypePoisson;

import fr.afpa.Poisson;
import fr.afpa.PoissonCarnivore;

public class Thon extends PoissonCarnivore {

    public Thon(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    @Override
    public void mangerViande(Poisson poisson) {

        throw new UnsupportedOperationException("Unimplemented method 'mangerViande'");
    }

}
