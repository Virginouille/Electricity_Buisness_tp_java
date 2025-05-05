package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BorneRecharge;

/**Classe LieuRecharge*/

public class LieuRecharge {

    /**Attributs*/
    private int id;
    private String nom, adresse;
    private List<BorneRecharge>borneRecharge = new ArrayList<BorneRecharge>();

    /**Constructeur*/


    /**Méthodes*/

    /**Méthode qui ajoute une borne dans la liste bornes*///Problement d'ajout à la liste à corriger
    public void ajouterBorne(BorneRecharge borne) {
        borneRecharge.add(borne);
        System.out.println("Borne" + borne.getNomBorne() + "ajoutée");
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
        return borneRecharge;
    }

    public List<BorneRecharge> getBorneRecharge() {
        return borneRecharge;
    }

    public void setBorneRecharge(List<BorneRecharge> borneRecharge) {
        this.borneRecharge = borneRecharge;
    }
}
