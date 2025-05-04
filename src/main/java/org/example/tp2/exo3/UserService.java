package org.example.tp2.exo3;

public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) {
        if (utilisateur.getNom() == null || utilisateur.getEmail() == null) {
            throw new IllegalArgumentException("Nom et Email sont obligatoires");
        }
        boolean success = utilisateurApi.creerUtilisateur(utilisateur);
        if (!success) {
            throw new ServiceException("Echec de la création de l'utilisateur");
        }
        int id = utilisateurApi.obtenirIdUtilisateur(utilisateur);
        utilisateur.setId(id);
    }
}
