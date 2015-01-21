package yuri.misyac.productmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuri.misyac.productmanager.dao.StoreDAO;
import yuri.misyac.productmanager.entity.Store;

@Service
public class StoreService {

    @Autowired
    private StoreDAO storeDAO;

    @Transactional
    public void addStore(Store store) {
        storeDAO.addStore(store);
    }

    @Transactional
    public Store getById(Integer id) {
        return storeDAO.getById(id);
    }

    @Transactional
    public void updateCount(Integer id, Integer amount){
        storeDAO.updateCount(id, amount);
    }
}
