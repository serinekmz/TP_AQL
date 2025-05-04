package org.example.tp2.exo2;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock (facultatif ici car la méthode ne retourne rien)
        //when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(null); // pas besoin, méthode void

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Vérifie qu’aucune autre interaction n’a eu lieu
        verifyNoMoreInteractions(utilisateurApiMock);
    }

    @Test
    public void testCreerUtilisateur_LeveException() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");

        // Simuler une exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        // Vérifier que l’exception est bien levée
        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Echec de la création de l'utilisateur", exception.getMessage());
    }

    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        Utilisateur utilisateurInvalide = new Utilisateur("Jean", "Dupont", "");

        UserService userService = new UserService(utilisateurApiMock);

        // Simuler une validation dans la méthode de service
        // Supposons qu'on ajoute une validation simple dans la méthode `creerUtilisateur`
        // ici on ne va PAS appeler utilisateurApi.creerUtilisateur si email vide

        // Appel
        assertThrows(IllegalArgumentException.class, () -> {
            userService.creerUtilisateur(utilisateurInvalide);
        });

        // Vérifie que la méthode n’a jamais été appelée
        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }



}
