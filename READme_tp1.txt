#  TP1  Couverture du code 

#  Objectifs du TP

Mesurer la couverture du code via les tests unitaires.

Comprendre les critères de couverture :

des lignes

des branches

des conditions

Utiliser IntelliJ IDEA pour analyser la couverture.

Écrire des tests plus complets et robustes.

#  EXERCICES :

Exercice 1 – Palindrome
Méthode à tester : Palindrome.isPalindrome(String s)

Cas de tests unitaires :

palindrome simple  : isPalindrome("kayak") → true 

palindrome avec majuscules/espaces : isPalindrome("Esope reste ici et se repose") → true 

pas un palindrome : isPalindrome("Bonjour") → false 

chaîne vide (par convention) : isPalindrome("") → true 

isPalindrome(null) → Exception attendue (NullPointerException)

un seul caractère (ou un seul caractère + espace) : isPalindrome("A ") → true 

Bug dans la méthode :


j++;
i--;
doit être remplacé par :

i++;
j--;


Exercice 2 – Anagrammes
Méthode à tester : Anagram.isAnagram(String s1, String s2)

Cas de tests unitaires :

isAnagram("chien", "niche") → true : anagramme

isAnagram("anagramme", "marganeam") → true

isAnagram("abc", "def") → false

isAnagram("abc", "ab") → false : longueurs différentes

isAnagram("A bc", "Cb a") → true : ignore espaces et casse

isAnagram(null, "test") → Exception attendue

isAnagram("test", null) → Exception attendue

 Bug dans la méthode :


for (int i = 0; i <= s1.length(); i++) {
devrait être :


for (int i = 0; i < s1.length(); i++) {


Exercice 3 – Recherche binaire


Méthode à tester : BinarySearch.binarySearch(int[] array, int element)

Cas de tests unitaires :

binarySearch([1, 2, 3, 4, 5], 3) → 2 : élément au milieu

binarySearch([1, 2, 3, 4, 5], 1) → 0  : premier

binarySearch([1, 2, 3, 4, 5], 5) → 4  : dernier

binarySearch([1, 3, 5, 7], 4) → -1 : absent

binarySearch([], 1) → -1

binarySearch(null, 3) → Exception attendue

binarySearch([1], 1) → 0 : singleton



Exercice 4 – Équation quadratique**

Méthode à tester : QuadraticEquation.solve(double a, double b, double c)

Cas de tests unitaires :
- `solve(1, -3, 2)` → `[2.0, 1.0]` : delta > 0
- `solve(1, -2, 1)` → `[1.0]` : delta = 0
- `solve(1, 0, 1)` → `null` : pas de solution réelle
- `solve(0, 2, 3)` → Exception attendue (division par 0)

---

Exercice 5 – Chiffres romains

**Méthode à tester** : RomanNumeral.toRoman(int n)

**Cas de tests unitaires :**
- `toRoman(1)` → `"I"`
- `toRoman(4)` → `"IV"`
- `toRoman(9)` → `"IX"`
- `toRoman(58)` → `"LVIII"`
- `toRoman(1994)` → `"MCMXCIV"`
- `toRoman(0)` → **Exception attendue**
- `toRoman(4000)` → **Exception attendue**
- `toRoman(3999)` → `"MMMCMXCIX"`

Bug dans la méthode :

for (int i = 0; i <= symbols.length; i++) {
devrait être :


for (int i = 0; i < symbols.length; i++) {


Exercice 6 – FizzBuzz

Méthode à tester : FizzBuzz.fizzBuzz(int n)

Cas de tests unitaires :

fizzBuzz(3) → "Fizz"

fizzBuzz(5) → "Buzz"

fizzBuzz(15) → "FizzBuzz"

fizzBuzz(7) → "7"

fizzBuzz(0) ou fizzBuzz(-1) → Exception attendue