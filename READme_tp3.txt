# TP3 - Tests d'Intégration en Java

## Objectif
Ce TP porte sur l'écriture de tests d'intégration en Java en utilisant JUnit et Mockito. Nous allons tester l'interaction entre différentes classes/modules dans des scénarios complexes croissants : interaction entre services, avec une base de données, et avec une API externe.


## Exercice 1 : Interaction Simple entre Modules

### Description
Dans cet exercice, nous avons deux classes : `UserService` qui interagit avec `UserRepository` pour récupérer des utilisateurs. Nous allons créer un test unitaire qui vérifie que la méthode `getUserById(long id)` appelle correctement la méthode `findUserById` de `UserRepository`.

### Étapes
1. Créez les classes `UserService` et `UserRepository`.
2. Implémentez un test pour vérifier que la méthode `findUserById` est appelée avec le bon paramètre lorsque `getUserById` est invoquée.

## Exercice 2 : Interaction avec une Base de Données avec des Mocks

### Description
Dans cet exercice, nous avons une interaction entre `OrderController`, `OrderService` et `OrderDao`. `OrderController` crée une commande, `OrderService` enregistre cette commande, et `OrderDao` persiste les informations dans une base de données.

### Étapes
1. Créez les classes `OrderController`, `OrderService` et `OrderDao`.
2. Implémentez des tests qui vérifient que `OrderService.createOrder` et `OrderDao.saveOrder` sont appelées correctement.

## Exercice 3 : Intégration d'API avec Mocking

### Description
Dans cet exercice, `ProductService` utilise `ProductApiClient` pour récupérer des informations d'un produit via une API externe. Nous allons tester cette interaction en simulant les réponses de l'API à l'aide de mocks.

### Étapes
1. Créez les classes `ProductService` et `ProductApiClient`.
2. Implémentez des tests pour vérifier que l'appel API fonctionne correctement et gérer les scénarios d'erreur.



## Conclusion
À la fin de ce TP, vous aurez une meilleure compréhension des tests d'intégration et des outils comme JUnit et Mockito pour simuler des interactions entre différents composants d'un système. Ces tests sont cruciaux pour valider la communication entre plusieurs parties d'une application.
