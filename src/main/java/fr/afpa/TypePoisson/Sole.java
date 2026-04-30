package fr.afpa.TypePoisson;

import fr.afpa.Algue;
import fr.afpa.PoissonHerbivore;

public class Sole extends PoissonHerbivore {

    public Sole(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    // public void sexeChanges() {

    // }

    @Override
    public void mangerAlgue(Algue algue) {

        throw new UnsupportedOperationException("Unimplemented method 'mangerAlgue'");
    }

}
