/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhk.repository;

import com.nhk.pojo.User;

/**
 *
 * @author 84355
 */
public interface UserRepository {
    User getUserByUsername(String username);
}
