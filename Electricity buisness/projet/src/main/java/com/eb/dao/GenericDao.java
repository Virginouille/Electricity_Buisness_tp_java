package com.eb.dao;

import java.util.List;

public interface GenericDao <T, ID>  {

        T creer(T entity);
        T trouverId(ID id);
        List<T> lireTous();
        T mettreAjour(T entity);
        void supprimer(T entity);
    }


