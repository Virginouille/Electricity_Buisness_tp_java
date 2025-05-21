package com.eb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**Enum Statut Réservation*/
@Entity
@Table(name = "statut_reservation")
public enum StatutReservation { //Ajouter @id pur faire le lien avec entité reservation
    EN_ATTENTE,
    ACCEPTEE;
}
