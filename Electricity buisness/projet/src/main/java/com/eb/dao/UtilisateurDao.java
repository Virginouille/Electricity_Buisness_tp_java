package com.eb.dao;

import com.eb.model.Utilisateur;
import org.hibernate.SessionFactory;

/**Classe utilisateurDao*/
public class UtilisateurDao extends GenericDaoImpl<Utilisateur, Integer> {

    /**
     * Constructeur session factory et entityclass
     *
     * @param sessionFactory
     */
    public UtilisateurDao(SessionFactory sessionFactory) {
        super(sessionFactory, Utilisateur.class);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
    }
}
