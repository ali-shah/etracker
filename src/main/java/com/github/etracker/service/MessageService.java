/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.service;

import com.github.etracker.database.Database;
import com.github.etracker.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class MessageService {
   
    private Map<Long, Message> messages  = Database.getMessages();;
   
    public MessageService() { 
        
        messages.put(1L, new Message(1,"Hello world", "Ali"));
        messages.put(2L, new Message(2,"Second message", "Taskeen"));
    }
    public List<Message> getMessages() {
        return new ArrayList<>(messages.values());
    }
    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }
    public void removeMessage(long id) {
         messages.remove(id);
    }
    
    public Message editMessage(Message message) {
        return messages.put(message.getId(), message);
    }
    
    public Message getMessage(long id) {
       return messages.get(id);
    }
}
