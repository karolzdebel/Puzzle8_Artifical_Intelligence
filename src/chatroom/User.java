/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

/**
 *
 * @author K
 */
public class User {
    
    private int age;
    private char gender;
    private String name;
    
    public User(String name, char gender, int age){
        this.age = age;
        this.gender = gender;
        this.name = name;
    }
    
    public String getNickname(){
        return name;
    }
    
    public Message createMessage(String content){
        return new Message(content,this);
    }
    
    
    
}
