package fr.afpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class PoissonCarnivore extends Poisson implements Carnivore {

    public PoissonCarnivore(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    public void mangerViande(Poisson poisson) {
        int ajoutPv = 5;
        int moinsPv = 4;
        String dateNow = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(this.getNom() + " mange " + poisson.getNom());

        this.setPv(getPv() + ajoutPv);
        String pvThisPoisson = (String.valueOf(getPv()));
        poisson.setPv(poisson.getPv() - moinsPv);
        String pvPoisson = (String.valueOf(poisson.getPv()));
        String newLog = (dateNow + " " + this.getNom() + " a mordu " + poisson.getNom() + "\n" + this.getNom()
                + " a gagné " + ajoutPv
                + ", il a désormais " + pvThisPoisson + " pv" + "\n" + poisson.getNom() + " a perdu " + moinsPv
                + " pv, il a désormais " + pvPoisson + " pv");
        Loggers.createLog(newLog);
    }
}
