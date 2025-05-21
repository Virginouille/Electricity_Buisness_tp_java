package com.eb;

import com.eb.dao.UtilisateurDao;
import com.eb.model.Utilisateur;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // Charger la config Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Créer DAO
        UtilisateurDao utilisateurDao = new UtilisateurDao(sessionFactory);

        // Créer un utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("utilisateur1@example.com");
        utilisateur.setMotDePasse("motdepasse123");
        utilisateur.setNomUtilisateur("Bob");
        utilisateur.setPrenomUtilisateur("Bob");

        // Insérer en bdd
        utilisateurDao.creer(utilisateur);

        // Récupérer l'utilisateur pour vérifier
        Utilisateur utilisateurRecup = utilisateurDao.trouverId(utilisateur.getId());
        if (utilisateurRecup != null) {
            System.out.println("Utilisateur récupéré : " + utilisateurRecup.getEmail());
        }

        // Fermer la session factory proprement
        sessionFactory.close();
    }

}
