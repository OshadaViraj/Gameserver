/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsbm.service;

import com.nsbm.common.CurrentPlayer;
import com.nsbm.common.PlayerStatus;
import static com.nsbm.common.ResponseResult.EXISTINGPLAYER;
import static com.nsbm.common.ResponseResult.SUCCESS;
import com.nsbm.entity.User;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lakshitha
 */
@Path("/PlayerHandler")
public class PlayerHandler {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addPlayer")
    public String addPlayer(User user) {
        user.setPlayerStatus(PlayerStatus.JOINED);
        Set<User> players = CurrentPlayer.getPLAYERS(); 
        boolean isAdded = players.add(user);

        if (!isAdded) {
            return EXISTINGPLAYER;
        }      
        System.out.println(user.getUsername() + " Joined");
        return SUCCESS;
    }
}
