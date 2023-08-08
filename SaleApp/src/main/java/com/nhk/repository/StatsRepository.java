/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 84355
 */
public interface StatsRepository {

    List<Object[]> countProductByCate();
    List<Object[]> statsRevenue(Map<String, String> params);

}
