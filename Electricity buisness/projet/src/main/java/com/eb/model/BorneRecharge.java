package com.eb.model;

import jakarta.persistence.*;

import java.util.Scanner;

/**Classe BorneRecharge*/
@Entity
@Table(name = "borne_recharge")
public class BorneRecharge { // Faire implements BornesServices

    //Problème ajout bornes qui fait n'imp entre borneRecharge et LieuRecharge
    /**Attributs*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "borne_recharge-id")
    private int id;

    @Column (name = "etat_borne")
    private EtatBorne etat;

    @Column (name = "tarif_horaire")
    private double tarifHoraire;

    @Column (name = "nom_borne")
    private String nomBorne;

    @ManyToOne
    @JoinColumn(name = "lieu_recharge_id")
    private LieuRecharge lieuRecharge;

    @OneToMany(mappedBy = "borne_recharge", cascade = CascadeType.ALL, orphanRemoval = true)
    private Reservation reservation;

    /**Constructeur*/
    //Constructeur par defaut
    //Pour l'instant le constructeur est par defaut à corriger pour éviter doublon console

    /**Méthode menu administration borne*/
    public void menuBorne() { //Gestion des cases en cours
        Scanner sc = new Scanner(System.in);
        String choixUtilisateur;
        System.out.println("=====================");
        System.out.println("Administration Bornes");
        System.out.println("=====================\n");

        System.out.println("1. Ajouter une borne");
        System.out.println("2. Modifier une borne");
        System.out.println("3. Supprimer une borne");


        choixUtilisateur = sc.nextLine();
        switch (choixUtilisateur) {
            case "1": ajoutBorne();
                break;
            case "2":
                break;
            case "3":
                break;
        }
    }

    /**Méthode attribution d'un id à la création d'une borne*/
    private int attributionId() { //A voir optimisation du nombre de chiffres
        int [] tableau = new int[6]; //Tableau qui va stocker les 6 chiffres de l'id

        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = (int)(Math.random()*10);
            //System.out.println(tableau[i]);
            id = id *10 + tableau[i];
        }
        System.out.println("ID : " + id);
        return id;
    }
    /**
     * Méthode ajoutBorne
     */
    private BorneRecharge ajoutBorne() { //Ajouter gestion erreurs

        String choixUtilisateur;
        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez un nom à votre borne");
        nomBorne = sc.nextLine();
        nomBorne = nomBorne.trim();
        System.out.println("Dans quel état est votre borne ?");
        System.out.println("1 - BON_ETAT");
        System.out.println("2 - ETAT_MOYEN");

        choixUtilisateur= sc.nextLine();
        if (choixUtilisateur.equals("1")) {
            etat = EtatBorne.BON_ETAT;
        } else if (choixUtilisateur.equals("2")) {
            etat = EtatBorne.ETAT_MOYEN;
        } else {
            System.out.println("Choix invalide");
        }

        System.out.println("Tarif horaire ?");
        tarifHoraire = sc.nextDouble();

        //Ajouter proposition de validation et donc enregistrement de la borne par le suite
        System.out.println("Nom borne : " + nomBorne);
        System.out.println("Etat borne : " + etat);
        System.out.println("Tarif horaire : " + tarifHoraire);
        System.out.println("ID Borne: " + id);

        BorneRecharge borne = new BorneRecharge();
        borne.setNomBorne(nomBorne);
        setEtat(etat);
        borne.setTarifHoraire(tarifHoraire);

        System.out.println("Borne créée : " + nomBorne + ", état : " + etat + ", tarif : " + tarifHoraire);
        return borne;
    }
    /**Méthode modification borne*/
    /**Méthode suppression borne*/

    /**Méthode toString()*/
    @Override
    public String toString() {
        return "Borne [ID: " + id +
                ", Nom: " + nomBorne +
                ", État: " + etat +
                ", Tarif horaire: " + tarifHoraire + " €/h]";
    }

    /**Getters et setters*/
    public int getId() {
        return id;
    }
    public int setId(int id) {
        this.id = id;
        return id;
    }
    public EtatBorne getEtat() {
        return etat;
    }
    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }
    public double getTarifHoraire() {
        return tarifHoraire;
    }
    public void setTarifHoraire(double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }
    public String getattributionId() {
        return String.valueOf(attributionId());
    }
    public BorneRecharge getAjoutBorne() {
        return ajoutBorne();
    }
    public String getNomBorne() {
        return nomBorne;
    }
    public void setNomBorne(String nomBorne) {
        this.nomBorne = nomBorne;
    }
}
