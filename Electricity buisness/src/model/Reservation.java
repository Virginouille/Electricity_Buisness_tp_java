package model;

import java.time.LocalDate;
import model.StatutReservation;

/**Classe réservation*/

public class Reservation {

    /**Attributs*/
    private int id;
    private Utilisateur utilisateur;
    private BorneRecharge borne;
    private LocalDate dateDebut, dateFin;
    private StatutReservation statut;
}
