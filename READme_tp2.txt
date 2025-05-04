#  TP : Tests Unitaires et Mocks avec Mockito
#  Objectifs :
Ce TP porte sur la simulation de tests unitaires dans le contexte de jeux de hasard, où nous allons simuler des interactions entre différents objets via le framework Mockito. L'objectif est de tester des méthodes dans un environnement contrôlé, en s'assurant qu'elles se comportent comme attendu dans différents scénarios


Exercice 1 : Initiation
Méthode à tester : additionner(int a, int b) : Cette méthode additionne deux nombres.

Cas de test :
Appel de la méthode additionner :

Tester l'addition de deux nombres positifs.

Tester l'addition d'un nombre positif et d'un nombre négatif.

Tester l'addition de deux nombres négatifs.

Vérification du résultat :

Vérifier que le résultat retourné par additionner correspond à la somme des deux nombres passés en paramètre.

Vérification des appels à la méthode :

Vérifier que la méthode additionner a bien été appelée avec les arguments 2 et 3.

Vérification qu'aucune autre méthode n'a été appelée :

Vérifier qu'aucune autre méthode n'a été appelée sur l'objet après l'appel de la méthode additionner.

Vérification de l'état de l'objet après l'appel de la méthode :

Vérifier que l'état de l'objet est correct après l'exécution de additionner.

Exercice 2 : Mocker un service externe (API)
Méthode à tester : creerUtilisateur(Utilisateur utilisateur) : Cette méthode envoie les informations du nouvel utilisateur à un service API pour créer un utilisateur.

Cas de test :
Configuration du comportement du mock :

Utiliser when(...).thenReturn(...) pour simuler un comportement de la méthode creerUtilisateur de l'API.

Création du service avec le mock :

Créer un objet UserService avec le mock de l'API utilisateur.

Appel de la méthode à tester :

Appeler creerUtilisateur du service UserService.

Vérification de l'appel à l'API :

Vérifier que la méthode creerUtilisateur du mock d'API a été appelée avec les bons paramètres.

Exercice 3 : Mocker un service externe avec différents scénarios
Méthode à tester : creerUtilisateur(Utilisateur utilisateur) : Comme dans l'exercice précédent, mais avec des scénarios supplémentaires.

Cas de test :
Lever une exception (ServiceException) :

Tester le comportement lorsque l'API lance une exception ServiceException.

Erreur de validation :

Tester le comportement en cas d'erreur de validation, en utilisant never() pour s'assurer qu'aucune autre méthode n'a été appelée sur le mock de l'API.

Renvoi d'un ID utilisateur unique :

Vérifier que l'API renvoie un identifiant pour l'utilisateur et vérifier cet ID dans le test.

Utilisation d'un ArgumentCaptor pour capturer les arguments passés à la méthode mockée :

Capturer l'argument Utilisateur passé à creerUtilisateur et vérifier les propriétés de l'objet capturé.

Exercice 4 : Jeu de dés
Méthode à tester : jouer(Joueur joueur, De de1, De de2) : Cette méthode simule le jeu avec deux dés et une banque qui gère les gains et les pertes.

Cas de test :
Jeu fermé :

Tester le cas où le jeu est déjà fermé avant l'appel à la méthode jouer.

Joueur insolvable :

Tester le cas où le joueur n'a pas assez d'argent pour faire un pari et vérifier que la méthode jouer ne touche pas aux dés.

Somme des dés ne vaut pas 7 :

Tester le cas où la somme des dés ne vaut pas 7 et vérifier que le joueur a perdu sa mise.

Somme des dés vaut 7 :

Tester le cas où la somme des dés vaut 7 et vérifier que le joueur double sa mise et que la banque est mise à jour en conséquence.

Banque insolvable après un gain :

Tester le cas où le joueur gagne, mais la banque devient insolvable après le paiement du gain, et vérifier que le jeu se ferme.

Vérification de l'état de la banque après un jeu :

Tester que l'état de la banque est mis à jour correctement après un pari gagnant ou perdant.

Vérification des interactions avec les objets mockés :

Vérifier que les interactions avec les objets Joueur, De et Banque sont correctes. Utiliser verify pour s'assurer que les bonnes méthodes ont été appelées avec les bons paramètres.