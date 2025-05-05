package ui;

import java.util.Scanner;

import model.EtatBorne;
import model.LieuRecharge;
import model.Utilisateur;
import model.BorneRecharge;

public class Main {
    public static void main(String[] args) {

        BorneRecharge borne = new BorneRecharge();//Pour test
        LieuRecharge lieuRecharge = new LieuRecharge();//Pour test

        /**Instances*///test
        Utilisateur utilisateur1 = new Utilisateur("email", "motdepasse");//Pour test

        /**Attribut*/
        String choixUtilisateur; //Déclaration variable choixUtilisateur

        /**Scanner pour choix utilisateur*/
        Scanner sc = new Scanner(System.in);
        /**Menu console*/
        System.out.println("=== Electricity Business ===");
        System.out.println("1. S'inscrire");
        System.out.println("2. Valider l'inscription");
        System.out.println("3. Se connecter");
        System.out.println("4. Rechercher & réserver une borne");
        System.out.println("5. Gérer mes réservations");
        System.out.println("6. Administration (lieux / bornes)");
        System.out.println("0. Quitter");
        System.out.println("Votre choix : ");

        choixUtilisateur = sc.nextLine();

        /**Switch case en fonction du choixUtilisateur*/
        switch (choixUtilisateur) {
            case "1": utilisateur1.inscriptionUtilisateur();//usage utilisateur1 pour test
                break;
            case "2" :
                break;
            case "3" : utilisateur1.connexionUtilisateur(utilisateur1);
                break;
            case "6": System.out.println("Que souhaitez-vous gérer (l)lieux (b) bornes ?");
                    choixUtilisateur = sc.nextLine();
                    if (choixUtilisateur.equalsIgnoreCase("l")) {
                        //lieuRecharge.menuLieu();
                    } else {
                        borne.menuBorne();
                    }
                break;
        }
    }
}

//Penser à fermer le scanner