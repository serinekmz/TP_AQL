package org.example.tp2.exo4;

// Jeu.java
public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise); // Essaye de débiter le joueur
        } catch (DebitImpossibleException e) {
            return; // Si le joueur est insolvable, on arrête
        }

        banque.crediter(mise); // Banque encaisse la mise

        int lancer1 = de1.lancer();
        int lancer2 = de2.lancer();
        int somme = lancer1 + lancer2;

        if (somme == 7) {
            banque.debiter(2 * mise); // Banque paye 2 fois la mise
            joueur.crediter(2 * mise); // Joueur gagne 2 fois la mise
        }

        if (!banque.est_solvable()) {
            fermer(); // Si la banque n'est plus solvable, on ferme le jeu
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}

