package kr.co.bblackhun.ecommerce.Admin.controller;

import kr.co.bblackhun.ecommerce.Admin.dto.ProductDTO;
import kr.co.bblackhun.ecommerce.Admin.model.Category;
import kr.co.bblackhun.ecommerce.Admin.model.Product;
import kr.co.bblackhun.ecommerce.Admin.service.CategoryService;
import kr.co.bblackhun.ecommerce.Admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("")
    public String adminHome() {
        return "Admin/adminHome";
    }

    @GetMapping("/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "Admin/categories";
    }

    @GetMapping("/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "Admin/categoriesAdd";
    }

    @PostMapping("/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCat(@PathVariable String id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/categories/update/{id}")
    public String updateCat(@PathVariable String id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            model.addAttribute("update", true);
            return "Admin/categoriesAdd";
        } else {
            return "404";
        }
    }

    //Product Section
    @GetMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "Admin/products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("update", false);
        model.addAttribute("categories", categoryService.getAllCategory());
        return "Admin/productsAdd";
    }
}
