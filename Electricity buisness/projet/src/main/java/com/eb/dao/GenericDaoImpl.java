package com.eb.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {

    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;

    /**Constructeur session factory et entityclass*/
    public GenericDaoImpl(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    /**Méthode CRUD pour créer une entité*
     * Initialise une transaction
     * Ouvre une session
     * Lance transaction depuis la sessiion
     * Persist l'entité en paramètre
     * Récupération de la transaction et commit
     * Erreur si entity nulle
     */

    @Override
    public T creer(T entity) {
        Transaction tx = null;
        try (Session session  = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
                return null;
            }
        }
        return entity;
    }

    /**Méthode pour faire une recherche via id*
     * Faire coincider id cherché et id dans Bdd
     * Message si pas id correspondant
     */

    @Override
    public T trouverId(ID id) {

        try (Session session = sessionFactory.openSession()) {

            return session.get(entityClass, id);
        } catch (Exception e) {
            System.out.println("Id introuvable");
            e.printStackTrace();
            return null;
        }

    }

    /**Méthode pour tout lire*
     * Fait une recherche hql sur tout
     * Si rien dans la liste renvoit liste vide
     */

    @Override
    public List<T> lireTous() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM " + entityClass.getSimpleName();
            return session.createQuery(hql, entityClass).getResultList();
        } catch (Exception e) {
            System.out.println("Aucune entitée trouvée");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**Méthode pour mettre à jour l'entité
     * Initialisation de la transaction
     * Lancement session
     * Modification entity
     * Levée exception si le merge est null avec un retour en arrière
     * et un message d'erreur pour informer*/

    @Override
    public T mettreAjour(T entity) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("Echec de la mise à jour");
                e.printStackTrace();
                return null;
            }
        }
        return entity;
    }

    /**Méthode pour supprimer l'entitée*
     * Lancement transaction
     * Initialisation et lancement session
     * Suppression de l'entité
     * Commit
     * Capturer erreur avec messsage si la suppression est un échec
     */

    @Override
    public void supprimer(T entity) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (tx != null) {
                System.out.println("Echec de la suppression");
                tx.rollback();
            }
        }
    }
}
