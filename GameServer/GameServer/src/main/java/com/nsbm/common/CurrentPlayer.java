/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsbm.common;

import com.nsbm.entity.User;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Lakshitha
 */
public class CurrentPlayer {
    private final static Set<User> PLAYERS = new HashSet<User>();
    private final static Map<User,String> PLAYERWORDS = new HashMap<User,String>();

    public static Set<User> getPLAYERS() {
        return PLAYERS;
    }

    public static Map<User, String> getPLAYERWORDS() {
        return PLAYERWORDS;
    }
    
    public static User findUser(String username){
        for(User user : PLAYERS){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    
}
