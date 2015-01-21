package yuri.misyac.productmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yuri.misyac.productmanager.entity.Product;
import yuri.misyac.productmanager.entity.Store;
import yuri.misyac.productmanager.service.ProductService;
import yuri.misyac.productmanager.service.StoreService;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/products")
    public String productList(Map<String, Object> map) {
        map.put("product", new Product());
        map.put("productList", productService.listProduct());

        return "product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result) {

        Store store = new Store();
        store.setCount(0);

        store.setProduct(product);
        product.setStore(store);

        productService.addProduct(product);

        return "redirect:/products";
    }

    @RequestMapping("/product_view/{contactId}")
    public String productView(@PathVariable("contactId") Integer contactId,
                              Map<String, Object> map) {

        String productName = productService.getById(contactId).getProductName();
        String productDescription = productService.getById(contactId).getProductDescription();
        Integer productCount = storeService.getById(contactId).getCount();

        map.put("id", contactId);
        map.put("name", productName);
        map.put("description", productDescription);
        map.put("count", productCount);

        return "product_view";
    }

    @RequestMapping("delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer productID) {

        productService.removeProduct(productID);

        return "redirect:/products";
    }

}
