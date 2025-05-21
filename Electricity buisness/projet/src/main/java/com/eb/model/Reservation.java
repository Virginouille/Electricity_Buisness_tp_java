package com.eb.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**Classe réservation*/
@Entity
@Table(name= "reservation")
public class Reservation {

    /**Attributs*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "utilisateurid")
    private Utilisateur utilisateur;

    private BorneRecharge borne;
    private LocalDate dateDebut, dateFin;
    private StatutReservation statut;

    /**Constructeur reservation*/
    public Reservation(int id, Utilisateur utilisateur, BorneRecharge borne, LocalDate dateDebut, LocalDate dateFin, StatutReservation statut) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.borne = borne;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public Reservation() {
    }

    /**Méthode pour créer une reservation*/
    public void creerReservation() { //EN COURS
        Utilisateur utilisateur = new Utilisateur("Doe", "John", "john.doe@example.com", 12345);//Pour test
        Disponibilite disponibilite = Disponibilite.DISPONIBLE;

        //Condition qui check si la borne est disponible
        if (disponibilite == Disponibilite.DISPONIBLE) {
            System.out.println("La borne est disponible");
        } else {
            System.out.println("La borne n'est pas disponible.");
        }
    }

    /**Getter et setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public BorneRecharge getBorne() {
        return borne;
    }

    public void setBorne(BorneRecharge borne) {
        this.borne = borne;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

}
