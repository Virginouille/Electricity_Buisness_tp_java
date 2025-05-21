package com.eb.dao;

import com.eb.model.Reservation;
import org.hibernate.SessionFactory;

public class ReservationDao extends GenericDaoImpl<Reservation, Integer> {

    /**
     * Constructeur session factory et entityclass
     *
     * @param sessionFactory
     * @param entityClass
     */
    public ReservationDao(SessionFactory sessionFactory, Class<Reservation> entityClass) {
        super(sessionFactory, entityClass);
    }
}
