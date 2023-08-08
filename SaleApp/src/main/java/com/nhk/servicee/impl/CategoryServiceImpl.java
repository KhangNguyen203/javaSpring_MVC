/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.servicee.impl;

import com.nhk.pojo.Category;
import com.nhk.repository.CategoryRepository;
import com.nhk.servicee.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 84355
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository; 

    @Override
    public List<Category> getCate() {
        return this.categoryRepository.getCate();
    }
    
}
