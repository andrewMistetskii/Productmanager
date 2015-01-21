package yuri.misyac.productmanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yuri.misyac.productmanager.entity.Product;
import yuri.misyac.productmanager.entity.Store;

import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @SuppressWarnings("unchecked")
    public List<Product> listProduct() {
        return sessionFactory.getCurrentSession().createQuery("from Product")
                .list();
    }

    public void removeProduct(Integer id) {
        Product product = (Product) sessionFactory.getCurrentSession().load(
                Product.class, id);
        if (null != product) {
            sessionFactory.getCurrentSession().delete(product);
        }
    }

    public Product getById(Integer id) {

        Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, id);

        return product;
    }
}
