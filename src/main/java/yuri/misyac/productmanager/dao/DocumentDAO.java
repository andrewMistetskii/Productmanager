package yuri.misyac.productmanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yuri.misyac.productmanager.entity.Document;

import java.util.List;

@Repository
public class DocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDocument(Document document) {
        sessionFactory.getCurrentSession().save(document);
    }

    @SuppressWarnings("unchecked")
    public List<Document> documentList(){
        return sessionFactory.getCurrentSession().createQuery("from Document").list();
    }

}
