/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.controllers;

import com.nhk.pojo.Product;
import com.nhk.servicee.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 84355
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
    
    @GetMapping("/products/{id}")
    public String update(Model model, @PathVariable(value = "id") int id ){
        model.addAttribute("product", this.productService.getProductById(id));
        return "products";
    }
    
    @PostMapping("/products")
    public String add(@ModelAttribute(value = "product") @Valid Product p, 
            BindingResult rs) {
        if(!rs.hasErrors())
            if (this.productService.addOrUpdate(p) == true)
                 return "redirect:/";
        
        return "products";
    }
}
