/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.controllers;

import com.nhk.servicee.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 84355
 */
@RestController
public class ApiProductController {
//    @Autowired
//    private ProductService productService;
//    
//    @DeleteMapping("/products/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteProduct(Model model, @PathVariable(value = "id") int id){
//        this.productService.deleteProduct(id);
//    }
    
     @Autowired
    private ProductService prodService;
    
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable(value = "id") int id) {
        this.prodService.deleteProduct(id);
    }
}
