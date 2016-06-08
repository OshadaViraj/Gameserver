/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsbm.service;

import static com.nsbm.common.CurrentPlayer.getPLAYERWORDS;
import static com.nsbm.common.ResponseResult.SUCCESS;
import com.nsbm.entity.User;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lakshitha
 */
@Path("/WordHandler")
public class WordHandler {
    
    private final static int MANUALLIMIT = 12;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLetters")
    public String getLetters(User user){
        Random r = new Random();
        String characters = new String();

        for(int i=0; i < MANUALLIMIT; i++){
            char c = (char) (r.nextInt(26) + 'a');
            characters = characters.concat("-" + c);
        }
        return characters;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{word}")
    public String addWord(User user, @PathParam("word") String word) {
        getPLAYERWORDS().put(user, word);
        System.out.println(getPLAYERWORDS());
        return SUCCESS;
    }
}
