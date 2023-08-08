/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.repository.impl;

import com.nhk.pojo.Category;
import com.nhk.pojo.SaleOrder;
import com.nhk.pojo.OrderDetail;
import com.nhk.pojo.Product;
import com.nhk.repository.StatsRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private SimpleDateFormat f; 
    
    @Override
    public List<Object[]> countProductByCate() {
        try ( Session session = this.factory.getObject().getCurrentSession()) {
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rP = q.from(Product.class);
            Root rC = q.from(Category.class);
            
            q.multiselect(rC.get("id"), rC.get("name"), b.count(rP.get("id")));  
            
            q.where(b.equal(rP.get("category"), rC.get("id")));
            q.groupBy(rC.get("id"));
            
            Query query = session.createQuery(q);
            return query.getResultList();
        }
    }
    
    @Override
    public List<Object[]> statsRevenue(Map<String, String> params) {
//       Session s = this.factory.getObject().getCurrentSession();
//       CriteriaBuilder b = s.getCriteriaBuilder();
//       CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//       Root rProd = q.from(Product.class);
//       Root rDetails = q.from(OrderDetail.class);
//       Root rOrder = q.from(SaleOrder.class);
//
//       List<Predicate> predicates = new ArrayList<>();
//       predicates.add(b.equal(rDetails.get("productId"), rProd.get("id")));
//       predicates.add(b.equal(rDetails.get("orderId"), rOrder.get("id")));
//
//       if (params != null) {
//           String kw = params.get("kw");
//           if (kw != null && !kw.isEmpty()) 
//               predicates.add(b.like(rProd.get("name"), String.format("%%%s%%", kw)));
//
//           String fd = params.get("fromDate");
//           if (fd != null && !fd.isEmpty())
//               try {
//                   b.greaterThanOrEqualTo(rOrder.get("createdDate"), f.parse(fd));
//               } catch (ParseException ex) {
//                   Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//               }
//
//           String td = params.get("toDate");
//           if (td != null && !td.isEmpty())
//               try {
//                   b.lessThanOrEqualTo(rOrder.get("createdDate"), f.parse(td));
//               } catch (ParseException ex) {
//                   Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//               }
//
//           String quarter = params.get("quarter");
//           if (quarter != null && !quarter.isEmpty()) {
//               String year = params.get("year");
//               if (year != null && !year.isEmpty()) {
//                   predicates.add(b.equal(b.function("YEAR", Integer.class, rOrder.get("createdDate")), Integer.parseInt(year)));
//                   predicates.add(b.equal(b.function("QUARTER", Integer.class, rOrder.get("createdDate")), Integer.parseInt(quarter)));
//               }
//           }
//       }
//
//       q.where(predicates.toArray(Predicate[]::new));
//       q.multiselect(rProd.get("id"), rProd.get("name"), b.sum(b.prod(rDetails.get("unitPrice"), rDetails.get("num"))));
//       q.groupBy(rProd.get("id"));
//
//       Query query = s.createQuery(q);
//       return query.getResultList();

        return null;
    }
}
