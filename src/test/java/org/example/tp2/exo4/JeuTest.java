package org.example.tp2.exo4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {

    private Banque banque;
    private Joueur joueur;
    private De de1;
    private De de2;
    private Jeu jeu;

    @BeforeEach
    public void setUp() {
        banque = mock(Banque.class);
        joueur = mock(Joueur.class);
        de1 = mock(De.class);
        de2 = mock(De.class);
        jeu = new Jeu(banque);
    }

    @Test
    public void testJeuFermeException() {
        jeu.fermer();
        assertFalse(jeu.estOuvert());

        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(joueur, de1, de2);
        });
    }

    @Test
    public void testJoueurInsolvable() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Insolvable")).when(joueur).debiter(anyInt());

        jeu.jouer(joueur, de1, de2);

        verifyNoInteractions(de1);
        verifyNoInteractions(de2);
        verify(banque, never()).crediter(anyInt());
    }

    @Test
    public void testPerteJoueur() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(50);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // somme = 5 ≠ 7

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(50);
        verify(banque).crediter(50);
        verify(banque, never()).debiter(anyInt());
        verify(joueur, never()).crediter(anyInt());
    }

    @Test
    public void testVictoireJoueur() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(40);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // somme = 7

        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(40);
        verify(banque).crediter(40);
        verify(banque).debiter(80); // banque paie 2x la mise
        verify(joueur).crediter(80);
    }

    @Test
    public void testBanqueDevientInsolvableApresGain() throws DebitImpossibleException, JeuFermeException {
        when(joueur.mise()).thenReturn(30);
        when(de1.lancer()).thenReturn(5);
        when(de2.lancer()).thenReturn(2); // somme = 7

        // Après paiement, banque devient insolvable
        when(banque.est_solvable()).thenReturn(false);

        jeu.jouer(joueur, de1, de2);

        assertFalse(jeu.estOuvert()); // le jeu doit être fermé après le gain
    }
}
