package fr.afpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class PoissonHerbivore extends Poisson implements Herbivore {

    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);

    }

    public void mangerAlgue(Algue algue) {

        int ajoutPv = 3;
        int moinsPv = 2;

        String dateNow = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        System.out.println(this.getNom() + " mange " + algue);

        this.setPv(getPv() + ajoutPv);
        String pvThisPoisson = (String.valueOf(getPv()));
        algue.setPv(algue.getPv() - moinsPv);

        String pvAlgue = (String.valueOf(algue.getPv()));
        String newLog = (dateNow + " | " + this.getNom() + " a mangé une algue" + ", " + this.getNom()
                + " a gagné " + ajoutPv
                + ", il a désormais " + pvThisPoisson + " pv" + ", " + "l'algue a perdu " + moinsPv
                + " pv, elle a désormais " + pvAlgue + " pv");
        Loggers.createLog(newLog);
    }

}