package kr.co.bblackhun.ecommerce.Admin.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String id;
    private String name;
    private String categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}
