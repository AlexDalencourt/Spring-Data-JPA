package fr.formation.sdj.controller;

import fr.formation.sdj.entities.User;
import fr.formation.sdj.repositories.OrderRepository;
import fr.formation.sdj.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String init(final ModelMap model) {
        model.put("userList", userRepository.findAll());
        model.put("userFilter", new User());
        model.put("orderList", orderRepository.findAll());
        return "order";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String filter(@ModelAttribute final User userFilter, final ModelMap model) {
        model.put("userList", userRepository.findAll());
        model.put("userFilter", userFilter);
        if (StringUtils.isBlank(userFilter.getName())) {
            model.put("orderList", orderRepository.findAll());
        } else {
            model.put("orderList", orderRepository.getAllByOwnerName(userFilter.getName()));
        }
        return "order";
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
