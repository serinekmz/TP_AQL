package org.example.tp1;

public class PalindromeChecker {

    /**
     * Vérifie si une chaîne donnée est un palindrome.
     * Un palindrome est un mot, une phrase, un nombre ou une autre séquence qui peut
     * être lue de la même manière de gauche à droite et de droite à gauche (en ignorant les espaces et la casse).
     *
     * @param s la chaîne à vérifier
     * @return true si la chaîne est un palindrome, false sinon
     * @throws NullPointerException si la chaîne est nulle
     */
    public static boolean isPalindrome(String s) {
        // Si la chaîne est nulle, on lève une exception
        if (s == null) {
            throw new NullPointerException("String must not be null");
        }

        // On convertit la chaîne en minuscule et on supprime les espaces
        s = s.toLowerCase().replaceAll("\\s+", "");

        // On initialise les indices de début et de fin de la chaîne
        int i = 0;
        int j = s.length() - 1;

        // On compare les caractères aux positions i et j jusqu'à ce qu'ils se rencontrent
        while (i < j) {
            // Si les caractères ne sont pas identiques, ce n'est pas un palindrome
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            // On avance les indices
            i++;
            j--;
        }

        // Si on a parcouru toute la chaîne sans trouver d'incohérence, c'est un palindrome
        return true;
    }

}
