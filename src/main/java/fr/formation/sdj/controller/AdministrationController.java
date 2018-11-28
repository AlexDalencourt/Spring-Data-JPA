package fr.formation.sdj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.sdj.repositories.OrderRepository;
import fr.formation.sdj.repositories.ProductRepository;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	private static final String CD_PARTERN = "CD-%";
	
	private static final String DISC_PATTERN = "LPvinyl-%";
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public String init(ModelMap model) {
		model.put("nbDiscAvailable", productRepository.countByNameLike(DISC_PATTERN));
		model.put("nbCdAvailable", productRepository.countByNameLike(CD_PARTERN));
		model.put("productList", productRepository.findAll());
        model.put("orderList", orderRepository.findAll());
		return "administration";
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
