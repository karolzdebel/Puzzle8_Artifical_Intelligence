/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.util.Date;

/**
 *
 * @author K
 */
public class Message {
    
    private final Date dateSent;
    private final User author;
    private final String content;
    
    public Message(String message, User author){
        this.dateSent = new Date();
        this.author = author;
        this.content = author.getNickname()+": "+message;
    }
    
    public String getContent(){
        return content;
    }
    
    public User getAuthor(){
        return author;
    }
    
    public Date getDateSent(){
        return dateSent;
    }
    
}
