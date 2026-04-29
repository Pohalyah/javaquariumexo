package fr.afpa;

public class Algue extends EtreVivant {

    public Algue(int pv, int age) {
        super(pv, age);
    }

    public Algue() {
        super(10, 0);
    }

    @Override
    public void vivreUnTour() {
        setPv(getPv() + 1);
        vieillir();

    }

    @Override
    public String toString() {

        return "Algue: " + getPv() + " " + getAge();
    }

}
