package yuri.misyac.productmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuri.misyac.productmanager.dao.ProductDAO;
import yuri.misyac.productmanager.entity.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    public List<Product> listProduct() {
        return productDAO.listProduct();
    }

    @Transactional
    public void removeProduct(Integer id) {
        productDAO.removeProduct(id);
    }

    @Transactional
    public Product getById(Integer id) {
        return productDAO.getById(id);
    }
}
