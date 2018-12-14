package fr.formation.sdj.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.sdj.entities.Order;
import fr.formation.sdj.entities.User;
import fr.formation.sdj.repositories.OrderRepository;
import fr.formation.sdj.repositories.UserRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public String init(final ModelMap model) {
		putCommonsDatasOnModel(new User(), model);
		model.put("orderList", orderRepository.findAll());
		return "order";
	}

	@PostMapping
	public String filter(@ModelAttribute final User userFilter, final ModelMap model) {
		putCommonsDatasOnModel(userFilter, model);
		if (StringUtils.isBlank(userFilter.getName())) {
			model.put("orderList", orderRepository.findAll());
		} else {
			model.put("orderList", orderRepository.getAllByOwnerName(userFilter.getName()));
		}
		return "order";
	}

	@GetMapping("/options")
	public String options(@RequestParam(required=false) List<String> sorters,@RequestParam(required=false, defaultValue="false") Boolean ascending,@RequestParam(required=false, defaultValue="false") Boolean paginator, final ModelMap model) {
		putCommonsDatasOnModel(new User(), model);
		if(sorters != null) {
			Sort sorter = Sort.by(sorters.toArray(new String[] {}));
			if(ascending) {
				sorter.ascending();
			}else {
				sorter.descending();
			}
			if(paginator) {
				Page<Order> result = orderRepository.findAll(PageRequest.of(0,4,sorter));
				model.put("orderList", result.getContent());	
				model.put("nbPages", result.getTotalPages());
			} else {
				model.put("orderList", orderRepository.findAll(sorter));		
			}
		} else {
			if(paginator) {
				Page<Order> result = orderRepository.findAll(PageRequest.of(0,4));
				model.put("orderList", result.getContent());	
				model.put("nbPages", result.getTotalPages());
			} else {
				model.put("orderList", orderRepository.findAll());
			}
		}
		model.put("sorters", sorters);
		model.put("ascending", ascending);
		model.put("paginator", paginator);
		return "order";
	}

	private void putCommonsDatasOnModel(User userFilter, ModelMap model) {
		model.put("userList", userRepository.findAll());
		model.put("userFilter", userFilter);
	}

	public void setUserRepository(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setOrderRepository(final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
