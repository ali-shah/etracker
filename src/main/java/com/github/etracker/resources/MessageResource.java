/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.resources;

import com.github.etracker.model.Message;
import com.github.etracker.service.MessageService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ali
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();

    @PUT
    @Path("/{messageId}")
    public Message editMessage(@PathParam("messageId") long id, Message message) {
        return messageService.editMessage(message);
    }
    @POST
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId")long id) {
         messageService.removeMessage(id);
    }
    
    @GET
    public List<Message> getMessages() {
        return messageService.getMessages();
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") String messageId) {
        Long l = Long.valueOf(messageId);
        return messageService.getMessage(l);
    }
    
 
}
