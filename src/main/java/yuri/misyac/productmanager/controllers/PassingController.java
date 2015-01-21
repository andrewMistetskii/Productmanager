package yuri.misyac.productmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yuri.misyac.productmanager.entity.Document;
import yuri.misyac.productmanager.entity.Product;
import yuri.misyac.productmanager.service.DocumentService;
import yuri.misyac.productmanager.service.ProductService;
import yuri.misyac.productmanager.service.StoreService;

import java.util.*;

@Controller
public class PassingController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/passing_document")
    public String strangerPage(Map<String, Object> map) {

        map.put("product", new Product());
        map.put("productList", productService.listProduct());
        map.put("document", new Document());
        map.put("documentList", documentService.documentList());

        return "passing";
    }

    @RequestMapping(value = "/addDocument", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("document") Document document, BindingResult result) {

        if (document.getProductId().equals(-1))
        {
            return "redirect:/passing_document";
        }

        if (document.getOperationType().equals("buy")) {
            buyProduct(document.getProductId(), document.getAmount());
        } else if (document.getOperationType().equals("sale")) {
            try {
                saleProduct(document.getProductId(), document.getAmount());
            } catch (Exception e) {
                return "redirect:/err";
            }
        } else if (document.getOperationType().equals("writeOff")) {
            try {
                saleProduct(document.getProductId(), document.getAmount());
            } catch (Exception e) {
                return "redirect:/err";
            }
        }

        document.setCreateDate(new Date());
        documentService.addDocument(document);

        return "redirect:/passing_document";
    }

    private void saleProduct(Integer productId, Integer amount) throws Exception {
        Integer currentCount = productService.getById(productId).getStore().getCount();
        Integer result = currentCount - amount;
        if (result < 0) {
            throw new Exception();
        } else {
            storeService.updateCount(productId, result);
        }
    }

    private void buyProduct(Integer productId, Integer amount) {
        Integer currentCount = productService.getById(productId).getStore().getCount();
        storeService.updateCount(productId, currentCount + amount);
    }

    @RequestMapping(value = "/err")
    public String errPage(){
        return "error";
    }

}
