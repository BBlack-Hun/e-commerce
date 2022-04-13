package kr.co.bblackhun.ecommerce.Cart.controller;

import kr.co.bblackhun.ecommerce.Admin.model.Product;
import kr.co.bblackhun.ecommerce.Admin.service.ProductService;
import kr.co.bblackhun.ecommerce.Cart.global.GlobalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable String id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "Shop/cart";
    }
}
