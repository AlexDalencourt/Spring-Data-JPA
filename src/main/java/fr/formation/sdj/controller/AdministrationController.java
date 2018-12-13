package fr.formation.sdj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.sdj.beans.CommandForm;
import fr.formation.sdj.entities.Product;
import fr.formation.sdj.entities.Stock;
import fr.formation.sdj.entities.Supplier;
import fr.formation.sdj.entities.pk.StockPK;
import fr.formation.sdj.repositories.OrderRepository;
import fr.formation.sdj.repositories.ProductRepository;
import fr.formation.sdj.repositories.StockRepository;
import fr.formation.sdj.repositories.SupplierRepository;

@Controller
@RequestMapping("/admin")
public class AdministrationController {

	private static final String CD_PARTERN = "CD-%";
	
	private static final String DISC_PATTERN = "LPvinyl-%";
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@GetMapping
	public String init(ModelMap model) {
		model.put("nbDiscAvailable", productRepository.countByNameLike(DISC_PATTERN));
		model.put("nbCdAvailable", productRepository.countByNameLike(CD_PARTERN));
		model.put("productList", productRepository.findAll());
        model.put("orderList", orderRepository.findAll());
		return "administration";
	}
	
	@GetMapping("/orders")
	public String filterOrders(@PathParam("dateAfter") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateAfter,@PathParam("dateBefore") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateBefore,ModelMap model) {
		model.put("orderList", orderRepository.findAllByDateBetween(dateAfter, dateBefore));
		return "fragments/table.html :: orderTable";
	}

	@GetMapping("/suppliers/{productId}")
	public String filterSuppliers(@PathVariable("productId") String productId, ModelMap model) {
		List<Supplier> suppliers = supplierRepository.findAllByCatalog_Id(Integer.valueOf(productId));
		CommandForm form = new CommandForm();
		List<Stock> stockForm = new ArrayList<>();
		for(Supplier supplier : suppliers) {
			Stock stock = new Stock(new StockPK(Integer.valueOf(productId), supplier.getSiret()), 0);
			stock.setSupplier(supplier);
			stockForm.add(stock);
		}
		form.setSuppliersCommand(stockForm);
		model.put("commandForm", form);
		return "fragments/modals.html :: commandToSupplierForm";
	}
	
	@PostMapping("/command")
	public String commandStock(@ModelAttribute final CommandForm form, final ModelMap model) {
		List<Stock> stocks = form.getSuppliersCommand();
		if(stocks != null && !stocks.isEmpty()) {
			Product product = productRepository.findById(stocks.get(0).getId().getProductId()).get();
			List<Stock> stockLeft = product.getStockLeft();
			ListIterator<Stock> stockIterator = stocks.listIterator();
			stocks.removeIf(curr -> curr.getStockLeft() == 0);
			stocks.forEach(curr -> {
				curr.setProduct(product); 
				curr.setSupplier(new Supplier(curr.getId().getSupplierId()));
				for(Stock stk : product.getStockLeft()) {
					if(stk.getId().getSupplierId().equals(curr.getId().getSupplierId())) {
						curr.setStockLeft(curr.getStockLeft() + stk.getStockLeft());
					}
				}
			});
			stockRepository.saveAll(stocks);
		}
		return "redirect:/admin";
	}
	
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
