/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.repository.impl;

import com.nhk.pojo.Category;
import com.nhk.repository.CategoryRepository;
import java.util.List;
import org.hibernate.Session;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 84355
 */
@Repository
@Transactional
public class CategoryRepositoryImpl  implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory; 
    
    @Override
    public List<Category> getCate() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        return q.getResultList();
    } 
}
