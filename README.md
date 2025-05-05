# Electricity_Buisness_tp_java



# Plateforme de Gestion de Bornes de Recharge – Projet Java (Console)

## 1. Portée

Ce projet est une application Java en mode console permettant de gérer des bornes de recharge pour véhicules électriques. Elle est conçue pour répondre aux besoins suivants :

- Gestion des utilisateurs (comptes, connexion)
- Administration des bornes et des lieux de recharge
- Système de réservation avec gestion des disponibilités
- Génération de documents (reçus)
- Interface utilisateur simple en console avec validation des entrées

---

## 2. Fonctionnalités

### ✅ Comptes utilisateurs
- **Inscription** : Génération d’un code unique lors de la création de compte
- **Validation du compte** : Activation par saisie du code
- **Connexion / Déconnexion** : Accès sécurisé par identifiants

---

### ⚡ Bornes & Lieux
- **Lieu** : Ajouter et modifier des lieux de recharge
- **Borne** : Ajouter, modifier une borne associée à un lieu
- **Suppression** : Une borne ne peut être supprimée que si elle n’a aucune réservation future

---

### 📅 Réservation
- **Recherche** : Trouver des bornes DISPONIBLES pour un créneau donné
- **Création** : L’utilisateur peut créer une réservation (statut initial : `EN_ATTENTE`)
- **Traitement** : Le propriétaire de la borne peut accepter ou refuser la réservation

---

### 📄 Documents
- **Génération automatique** d’un **reçu (.txt)** lors de l’acceptation d’une réservation

---

### 🖥️ IHM Console
- **Menu principal** clair et structuré
- **Validation robuste** des saisies utilisateurs (erreurs, mauvais formats, etc.)

---

## 3. Technologies

- Java 17+
- Programmation orientée objet
- Console (pas d’interface graphique)
- Utilisation de `Enum`, `List`, `Scanner`, `toString`, etc.

---

## 4. Lancement

Compile et exécute la classe `Main` pour démarrer l'application.

---

## 5. Auteur

- Développé par Virginie ✨

---

