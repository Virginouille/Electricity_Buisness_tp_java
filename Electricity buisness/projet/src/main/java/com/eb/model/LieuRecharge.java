package com.eb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Classe LieuRecharge*/
@Entity
@Table(name = "lieu_recharge")
public class LieuRecharge {

    /**Attributs*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lieu_recharge_id")
    private int id;

    @Column(name = "nom", length = 100)
    @NotBlank
    private String nom;

    @Column(name = "adresse")
    @NotBlank
    private String adresse;

    @OneToMany(mappedBy = "lieu_recharge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorneRecharge>borneRecharges = new ArrayList<BorneRecharge>();

    /**Constructeur*/


    /**Méthodes*/

    /**Méthode qui ajoute une borne dans la liste bornes*///Problement d'ajout à la liste à corriger
    public void ajouterBorne(BorneRecharge borne) {
        borneRecharges.add(borne);
        System.out.println("Borne " + borne.getNomBorne() + " ajoutée à la liste des bornes");
    }

    /**
     * Méthode pour afficher les bornes présentent dans la liste
     */
    @Override
    public String toString() {
        return "listes bornes" + borneRecharges.toString();
    }

    /**Méthode qui permet d'ajouter un lieu de recharge*/
    public String ajouterLieuRecharge() {

        Scanner sc = new Scanner(System.in);
        String choixUtilisateur;
        System.out.println("LieuRecharge");
        System.out.println("Nom du lieu : ");
        choixUtilisateur = sc.nextLine();
        System.out.println("Adresse : ");
        choixUtilisateur = sc.nextLine();

        return choixUtilisateur;
    }

    /**Getters et setters*/
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public List<BorneRecharge> getBornesRecharge() {
        return borneRecharges;
    }

    public List<BorneRecharge> getBorneRecharge() {
        return borneRecharges;
    }

    public void setBorneRecharge(List<BorneRecharge> borneRecharge) {
        this.borneRecharges = borneRecharge;
    }
}
