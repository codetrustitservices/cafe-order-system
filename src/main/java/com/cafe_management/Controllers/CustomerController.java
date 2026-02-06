package com.cafe_management.Controllers;

import com.cafe_management.Model.Order;
import com.cafe_management.Services.MenuService;
import com.cafe_management.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("menuItems",menuService.getAvailableMenuItems());
        return "customer/home";
    }

    @GetMapping("/menu")
    public String menu(Model model){
        model.addAttribute("menuItems", menuService.getAvailableMenuItems());
        return "customer/menu";
    }

    @PostMapping("/order/place")
    public String placeOrder(@ModelAttribute Order order, RedirectAttributes ra){
        orderService.createOrder(order);
        ra.addFlashAttribute("success", "Order placed ");
        return "redirect:/order/confirmation";
    }
}
