package fr.afpa;

public abstract class PoissonHerbivore extends Poisson implements Herbivore {

    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    public void mangerAlgue(Algue algue) {

        this.setPv(getPv() + 3);
        algue.setPv(algue.getPv() - 2);

    }

}