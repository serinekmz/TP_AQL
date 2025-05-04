package org.example.tp2.exo4;

// BanqueImpl.java
public class BanqueImpl implements Banque {
    private int fond;
    private int fondMin;

    public BanqueImpl(int fondInitial, int fondMin) {
        this.fond = fondInitial;
        this.fondMin = fondMin;
    }

    @Override
    public void crediter(int somme) {
        fond += somme;
    }

    @Override
    public boolean est_solvable() {
        return fond >= fondMin;
    }

    @Override
    public void debiter(int somme) {
        fond -= somme;
    }

    public int getFond() {
        return fond;
    }
}

