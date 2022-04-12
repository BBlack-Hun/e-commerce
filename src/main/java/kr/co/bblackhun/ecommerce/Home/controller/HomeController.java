package kr.co.bblackhun.ecommerce.Home.controller;

import kr.co.bblackhun.ecommerce.Admin.service.CategoryService;
import kr.co.bblackhun.ecommerce.Admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoryService categoryService;

    private final ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {

        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProducts());
        return "Shop/shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable String id, Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "Shop/shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable String id) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "Shop/viewProduct";
    }
}
