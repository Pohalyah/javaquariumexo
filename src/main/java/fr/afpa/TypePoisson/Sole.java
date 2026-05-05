package fr.afpa.TypePoisson;

import fr.afpa.Algue;
import fr.afpa.Poisson;
import fr.afpa.PoissonHerbivore;

public class Sole extends PoissonHerbivore implements HermaphroditeSexe {

    public Sole(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    @Override
    public void mangerAlgue(Algue algue) {

    }

    @Override
    public void changeSexe(Poisson partenaire) {
        if (getSexe() == partenaire.getSexe()) {

            if (partenaire.getSexe() == Sexe.FEMELLE) {
                setSexe(Sexe.MALE);
            } else {
                setSexe(Sexe.FEMELLE);
            }
        }
    }

}
