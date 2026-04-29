package fr.afpa;

public abstract class EtreVivant {
    private int pv;
    private int age;

    public EtreVivant(int pv, int age) {
        this.pv = pv;
        this.age = age;
    }

    public void vieillir() {
        this.age++;
    }

    public abstract void vivreUnTour();

    public boolean estMort() {
        if (pv <= 0 || age >= 20) {
            return true;
        } else {
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public int getPv() {
        return pv;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
}
