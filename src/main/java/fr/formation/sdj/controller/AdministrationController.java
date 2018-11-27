package fr.formation.sdj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.sdj.repositories.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	private static final String CD_PARTERN = "CD-%";
	
	private static final String DISC_PATTERN = "LPvinyl-%";
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public String init(ModelMap model) {
		model.addAttribute("nbDiscAvailable", productRepository.countByNameLike(DISC_PATTERN));
		model.addAttribute("nbCdAvailable", productRepository.countByNameLike(CD_PARTERN));
		model.addAttribute("productList", productRepository.findAll());
		return "administration";
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
}
