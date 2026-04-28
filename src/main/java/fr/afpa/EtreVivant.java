package fr.afpa;

public abstract class EtreVivant {
    private int pv;
    private int age;

    public EtreVivant(int pv, int age) {
        this.pv = pv;
        this.age = age;
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
