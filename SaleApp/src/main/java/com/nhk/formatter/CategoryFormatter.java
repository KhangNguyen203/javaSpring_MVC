/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.formatter;

import com.nhk.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author 84355
 */
public class CategoryFormatter implements Formatter<Category>{

     @Override
    public String print(Category cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
        return new Category(Integer.parseInt(cateId));
    }
    
}
