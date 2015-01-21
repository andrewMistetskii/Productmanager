package yuri.misyac.productmanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yuri.misyac.productmanager.entity.Store;

@Repository
public class StoreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStore(Store store) {
        sessionFactory.getCurrentSession().save(store);
    }

    public Store getById(Integer id) {
        Store store = (Store) sessionFactory.getCurrentSession().get(Store.class, id);
        return store;
    }

    public void updateCount(Integer id, Integer amount) {
        Store store = getById(id);
        store.setCount(amount);
        sessionFactory.getCurrentSession().update(store);
    }
}
