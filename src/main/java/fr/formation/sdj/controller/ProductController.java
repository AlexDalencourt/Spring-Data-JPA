package fr.formation.sdj.controller;

import fr.formation.sdj.entities.Product;
import fr.formation.sdj.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(final ModelMap model) {
        model.put("productList", productRepository.findAll());
        model.put("productRef", model.get("productList"));
        model.put("productFilter", new Product());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String filter(@ModelAttribute final Product product, final ModelMap model) {
        model.put("productRef", productRepository.findAll());
        if (product.getName() == null) {
            model.put("productList", model.get("productRef"));
        } else {
            model.put("productList", productRepository.findAllByName(product.getName()));
        }
        model.put("productFilter", new Product());
        return "home";
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
