package fr.afpa.TypePoisson;

import fr.afpa.Algue;
import fr.afpa.PoissonHerbivore;

public class Bar extends PoissonHerbivore implements HermaphroditeAge {

    public Bar(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    @Override
    public void mangerAlgue(Algue algue) {

        throw new UnsupportedOperationException("Unimplemented method 'mangerAlgue'");
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
