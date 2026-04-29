package fr.afpa;

public abstract class PoissonCarnivore extends Poisson implements Carnivore {

    public PoissonCarnivore(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    public void mangerViande(Poisson poisson) {
        System.out.println(this.getNom() + " mange " + poisson.getNom());

        this.setPv(getPv() + 5);
        poisson.setPv(poisson.getPv() - 4);

    }
}
