package org.example.tp2.exo3;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
