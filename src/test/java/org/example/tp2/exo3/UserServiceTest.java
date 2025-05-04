package org.example.tp2.exo3;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(utilisateurApiMock);
    }

    @Test
    public void testCreationUtilisateur_Echec() {
        Utilisateur utilisateur = new Utilisateur("John", "john@example.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(false);

        ServiceException exception = assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        assertEquals("Echec de la création de l'utilisateur", exception.getMessage());
    }

    @Test
    public void testValidationErreur() {
        Utilisateur utilisateur = new Utilisateur(null, "email@example.com");

        assertThrows(IllegalArgumentException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    @Test
    public void testAffectationIdUtilisateur() {
        Utilisateur utilisateur = new Utilisateur("Alice", "alice@example.com");

        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        int idUtilisateur = 123;
        when(utilisateurApiMock.obtenirIdUtilisateur(utilisateur)).thenReturn(idUtilisateur);

        userService.creerUtilisateur(utilisateur);

        assertEquals(idUtilisateur, utilisateur.getId());
    }

    @Test
    public void testCaptureArguments() {
        Utilisateur utilisateur = new Utilisateur("Bob", "bob@example.com");

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);

        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);
        when(utilisateurApiMock.obtenirIdUtilisateur(any(Utilisateur.class))).thenReturn(456);

        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        assertEquals("Bob", utilisateurCapture.getNom());
        assertEquals("bob@example.com", utilisateurCapture.getEmail());
    }
}
