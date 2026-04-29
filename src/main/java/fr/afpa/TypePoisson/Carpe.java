package fr.afpa.TypePoisson;

import fr.afpa.Algue;
import fr.afpa.PoissonHerbivore;

public class Carpe extends PoissonHerbivore {

    public Carpe(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    @Override
    public void mangerAlgue(Algue algue) {

        throw new UnsupportedOperationException("Unimplemented method 'mangerAlgue'");
    }

}
