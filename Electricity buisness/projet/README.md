README app Electricity Buisness V2

CLasses
# Classe `Utilisateur` – Module Java `com.eb.model`

Cette classe représente un **utilisateur** de la plateforme. Elle est conçue avec **JPA/Hibernate** pour la persistance en base de données, et elle inclut des **validations avec Jakarta Bean Validation**.

## 📦 Package
`com.eb.model`

---

## ✅ Fonctionnalités principales

- Inscription d’un utilisateur avec génération et validation d’un **code aléatoire à 4 chiffres**.
- Connexion utilisateur avec vérification d’e-mail et mot de passe.
- Liaison à des réservations via une relation `@OneToMany`.
- Intégration de **validations sur les champs** (`@NotBlank`, `@Email`, etc.).
- Sauvegarde en base grâce aux annotations **JPA**.

---

## 🧾 Attributs principaux

| Champ                | Type     | Description                                          |
|---------------------|----------|------------------------------------------------------|
| `id`                | `int`    | Identifiant unique, clé primaire                    |
| `email`             | `String` | Adresse e-mail unique, validée                      |
| `motDePasse`        | `String` | Mot de passe de l'utilisateur                      |
| `nomUtilisateur`    | `String` | Nom de famille de l'utilisateur                    |
| `prenomUtilisateur` | `String` | Prénom de l'utilisateur                             |
| `estValide`         | `boolean`| Statut de validation du compte                      |
| `codeDeValidation`  | `int`    | Code aléatoire généré pour valider le compte        |
| `reservations`      | `List<Reservation>` | Liste des réservations de l'utilisateur |

---

## 🔗 Relations

- `@OneToMany` avec la classe `Reservation` :
  ```java
  @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Reservation> reservations = new ArrayList<>();

## 🔁 Interface `GenericDao<T, ID>`

Cette interface générique définit les opérations CRUD de base à implémenter pour toutes les entités persistantes. Elle permet d'abstraire la logique de gestion des entités avec un **type générique `T`** et un **identifiant `ID`**.

### 📂 Package
`com.eb.dao`

---

### 📌 Méthodes définies

| Méthode                        | Description                                                  |
|-------------------------------|--------------------------------------------------------------|
| `T creer(T entity)`           | Crée et enregistre une nouvelle entité                      |
| `T trouverId(ID id)`          | Recherche une entité à partir de son identifiant            |
| `List<T> lireTous()`          | Retourne la liste de toutes les entités persistées          |
| `T mettreAjour(T entity)`     | Met à jour une entité existante                             |
| `void supprimer(T entity)`    | Supprime une entité de la base                              |

---

### 🎯 Objectif

L'interface `GenericDao` sert de **contrat commun** pour tous les DAO spécifiques (par exemple `UtilisateurDao`, `ReservationDao`, etc.), ce qui facilite :

- La factorisation de code
- Le respect du principe DRY (Don't Repeat Yourself)
- L’extensibilité et la réutilisabilité

---

### 🧩 Exemple d’implémentation

```java
@Repository
public class UtilisateurDaoImpl implements GenericDao<Utilisateur, Integer> {
    // Implémentation des méthodes CRUD avec EntityManager
}

## 🧱 Classe Abstraite `GenericDaoImpl<T, ID>`

Cette classe implémente l'interface `GenericDao` avec Hibernate et fournit une implémentation générique des opérations CRUD. Elle doit être étendue par chaque DAO spécifique (ex. : `UtilisateurDaoImpl`).

---

### 📂 Package
`com.eb.dao`

---

### 🏗️ Constructeur

```java
public GenericDaoImpl(SessionFactory sessionFactory, Class<T> entityClass)
