package fr.afpa;

public abstract class Poisson extends EtreVivant {
    private String nom;
    private Sexe sexe;

    public Poisson(String nom, Sexe sexe) {
        super(10, 0);
        this.nom = nom;
        this.sexe = sexe;
    }

    @Override
    public void vivreUnTour() {
        setPv(getPv() - 1);
        vieillir();
    }

    public enum Sexe {
        MALE,
        FEMELLE
    }

    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {

        return "Poisson: " + getNom() + ", " + getSexe() + ", " + getPv() + " PV, " + getAge() + " d'age";
    }

}
