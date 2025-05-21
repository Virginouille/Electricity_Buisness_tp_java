package com.eb.dao;

import com.eb.model.BorneRecharge;
import org.hibernate.SessionFactory;

public class BorneRechargeDao extends GenericDaoImpl<BorneRecharge, Integer> {

    /**
     * Constructeur session factory et entityclass
     *
     * @param sessionFactory
     * @param entityClass
     */
    public BorneRechargeDao(SessionFactory sessionFactory, Class<BorneRecharge> entityClass) {
        super(sessionFactory, entityClass);
    }
}
