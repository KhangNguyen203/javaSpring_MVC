/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.repository;

import com.nhk.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 84355
 */
public interface ProductRepository {
        List<Product> getProduct(Map<String, String> params);
        int countProduct();
        boolean addOrUpdate(Product p);
        Product getProductById(int id);
        boolean deleteProduct(int id);
}


