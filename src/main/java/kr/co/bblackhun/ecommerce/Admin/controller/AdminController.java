package kr.co.bblackhun.ecommerce.Admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("")
    public String adminHome() {
        return "Admin/adminHome";
    }

    @GetMapping("/categories")
    public String getCat() {
        return "Admin/categories";
    }

    @GetMapping("/categories/add")
    public String getCatAdd() {
        return "Admin/categoriesAdd";
    }
}
