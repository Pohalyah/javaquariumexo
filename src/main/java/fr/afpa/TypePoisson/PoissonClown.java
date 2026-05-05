package fr.afpa.TypePoisson;

import fr.afpa.Poisson;
import fr.afpa.PoissonCarnivore;

public class PoissonClown extends PoissonCarnivore implements HermaphroditeSexe {

    public PoissonClown(String nom, Sexe sexe) {
        super(nom, sexe);

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
