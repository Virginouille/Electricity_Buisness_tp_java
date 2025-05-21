package com.eb.dao;

import com.eb.model.LieuRecharge;
import org.hibernate.SessionFactory;

public class LieuRechargeDao extends GenericDaoImpl<LieuRecharge, Integer> {

    /**
     * Constructeur session factory et entityclass
     *
     * @param sessionFactory
     * @param entityClass
     */
    public LieuRechargeDao(SessionFactory sessionFactory, Class<LieuRecharge> entityClass) {
        super(sessionFactory, entityClass);
    }

}
