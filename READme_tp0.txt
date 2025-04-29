# TP0 - Tests Unitaires avec JUnit 5

## Objectifs

Ce TP a pour objectifs de se familiariser avec :
- L'installation et la configuration de JUnit 5 dans un projet Maven avec IntelliJ IDEA.
- L'écriture et l'exécution de tests unitaires.
- L'utilisation des annotations, assertions, hypothèses, tests paramétrés et dynamiques de JUnit 5.
- L'application de la méthode d’équivalence de classes pour les cas de tests.

---
Exercices
1. Classe Person
Méthodes à tester : getFullName(), isAdult()

Cas de test : nom/prénom vides, âge limite (17, 18, 19)

2. Classe Stack
Méthodes à tester : push(), pop(), peek(), isEmpty(), size()

Cas de test : pile vide, dépassement de capacité, enchaînement push/pop

3. Classe Fibonacci
Méthode à tester : fibonacci(int n)

Cas de test : n = 0, n = 1, n = 5, n = -1 (exception)

4. Classe Prime
Méthode à tester : isPrime(int n)

Cas de test : n = 1, n = 2, n = 15, n = 17

5. Classe Factorial
Méthode à tester : factorial(int n)

Cas de test : n = 0, n = 5, n = -1 (exception)


Bonnes Pratiques
Respecter la règle AAA : Arrange, Act, Assert

Isoler chaque test

Nommer les méthodes de test de manière descriptive

Utiliser des tests paramétrés pour éviter la redondance

