package kr.co.bblackhun.ecommerce.Cart.global;

import kr.co.bblackhun.ecommerce.Admin.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Product> cart;
    static {
        cart = new ArrayList<>();
    }
}
