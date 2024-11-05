package com.javatechie.resource;

import com.javatechie.entity.Product;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getProducts(){
        return  productService.getProducts();
    }


   @QueryMapping
    public List<Product> getProductsByCategory( @Argument String category){
        return  productService.getProductsByCategory(category);
    }


    @MutationMapping
    public  Product updateTheStock(@Argument Integer id, @Argument Integer stock){
    return  productService.updateStock(id,stock);
    }

    @MutationMapping
    public  Product recieveNewShipment(@Argument Integer id, @Argument Integer quantity){
        return  productService.recieveNewShipment(id,quantity);
    }
}
