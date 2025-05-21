package com.eb.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


/**Classe utilisateur*/
@Entity
@Table(name= "utilisateur")
public class Utilisateur { //implements AuthentificationService

    /**Attributs de la classe utilisateur*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private int id;

    private int codeDeValidation = 0;
    private boolean estValide = true;

    @Column(name = "email", unique=true, nullable=false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "mot_de_passe")
    @NotBlank
    private String motDePasse;

    @Column(name ="nom_utilisateur")
    @NotBlank
    private String nomUtilisateur;

    @Column(name ="prenom_utilisateur")
    @NotBlank
    private String prenomUtilisateur;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();


    /**Constructeur Utilisateur*/
    public Utilisateur(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    //Constucteur pour réservation
    public Utilisateur(String nomUtilisateur, String prenomUtilisateur,String email, int id) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.email = email;
        this.id = id;
    }

    public Utilisateur() {

    }

    /***Méthodes****/
    /**Méthode inscription utilisateur*/ //Séparer cette méthode pour faire le lien entre le 1 et 2 du menu
    public Utilisateur inscriptionUtilisateur() {

        Scanner sc = new Scanner(System.in);
        System.out.println("===========");
        System.out.println("Inscription");
        System.out.println("===========\n");
        System.out.println("Veuillez entrer votre email");
        email = sc.nextLine();
        System.out.println("Veuillez choisir un mot de passe");//Pour l'instant 8 caractères mais après ajouter majuscule et autres caractères spéciaux.
        motDePasse = sc.nextLine();
            generationCode();
        do {
            System.out.println("Veuillez entrer votre code de validation");
            validationCode(sc.nextInt()); //A faire bloquer la saisie si code autre que 4 chiffres
        } while (estValide==false);

        return new Utilisateur(email, motDePasse);
    }

    /**Méthode validation email*/ //A faire pour bien cadrer l'entrée des mails
    /**Méthode validation mot de passe*/ //A faire pour demander des caractères spécifiques
    /**Méthode pour générer un code aléatoire à 4 chiffres**/
    private int generationCode() {
        int [] tableau = new int[4]; //Tableau qui va stocker les chiffres

        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = (int)(Math.random()*10);
            //System.out.println(tableau[i]);
            codeDeValidation = codeDeValidation *10 + tableau[i];
        }
        System.out.println("Votre code de validation : " + codeDeValidation);
        return codeDeValidation;

    }
    /**Méthode pour valider si le code entré est = au code reçu*/
    private boolean validationCode(int codeEntre) {
        if(codeEntre == codeDeValidation) {
            System.out.println("Votre compte client est crée");
            estValide = true;
        } else {
            System.out.println("Votre code de validation est faux");
            estValide = false;
        }
        return estValide;
    }

    /**Méthode connexion Utilisateur**/ //A ameliorer en ajouter message erreurs et voir pour ajouter une méthode trim()
    public boolean connexionUtilisateur(Utilisateur utilisateur) {

        boolean validationConnexion = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez entrer votre email");
        String saisieEmail = sc.nextLine();

        System.out.println("Veuillez choisir un mot de passe");
        String saisieMotDePasse = sc.nextLine();

        boolean emailValide = saisieEmail.equalsIgnoreCase(utilisateur.getEmail());
        boolean motDePasseValide = saisieMotDePasse.equalsIgnoreCase(utilisateur.getMotDePasse());

        if (emailValide && motDePasseValide) {
            System.out.println("Connexion Validée");
            return true;
        } else {
            System.out.println("Connexion Invalide");
            return false;
        }
    }
    /**Méthode deconnexion Utilisateur**/

    /**Getters et setters*/
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCodeDeValidation() {
        return codeDeValidation;
    }
    public void setCodeDeValidation(int codeDeValidation) {
        this.codeDeValidation = codeDeValidation;
    }
    public boolean getEstValide() {
        return estValide;
    }
    public String getEmail() {
        return email;
    }
    public void setGetEmail() {
        this.email = email;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public int getGenerationCode() {
        return generationCode();
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
