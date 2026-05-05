package fr.afpa.TypePoisson;

import fr.afpa.PoissonCarnivore;

public class Merou extends PoissonCarnivore implements HermaphroditeAge {

    public Merou(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    @Override
    public void changeSexe() {
        if (getAge() == 10) {
            if (getSexe() == Sexe.MALE) {
                setSexe(Sexe.FEMELLE);
            } else {
                setSexe(Sexe.MALE);
            }
        }
    }

}
