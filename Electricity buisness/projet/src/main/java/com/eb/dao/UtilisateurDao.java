package com.eb.dao;

import com.eb.model.Utilisateur;
import org.hibernate.SessionFactory;

/**Classe utilisateurDao*/
public class UtilisateurDao extends GenericDaoImpl<Utilisateur, Integer> {

    /**
     * Constructeur session factory et entityclass
     *
     * @param sessionFactory
     * @param entityClass
     */
    public UtilisateurDao(SessionFactory sessionFactory, Class<Utilisateur> entityClass) {
        super(sessionFactory, entityClass);
    }
}
