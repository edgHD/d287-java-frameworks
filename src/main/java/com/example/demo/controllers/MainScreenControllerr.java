package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @PostMapping("/buyProduct")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> buyProduct(@RequestParam("productID") long productId) {
        Map<String, Object> response = new HashMap<>();
        // Find the product by ID
        Product product = productService.findById((int)productId);

        if (product == null) {
            response.put("success", false);
            response.put("message", "Product not found");
            return ResponseEntity.badRequest().body(response);
        }

        // Check if product is in stock
        if (product.getInv() <= 0) {
            response.put("success", false);
            response.put("message", "Sorry, this product is out of stock");
            return ResponseEntity.ok(response);
        } else {
            // Decrement inventory by 1
            product.setInv(product.getInv() - 1);
            productService.save(product);

            response.put("success", true);
            response.put("message", "Thank you for your purchase!");
            response.put("newInventory", product.getInv());
            return ResponseEntity.ok(response);
        }
    }
}
