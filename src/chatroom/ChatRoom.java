/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.util.ArrayList;

/**
 *
 * @author K
 */
public class ChatRoom {

    /**
     * @param args the command line arguments
     */
    
    ArrayList<User> users;
    ArrayList<Message> messages;
    ArrayList<ChatRoomFrame> chatRoomFrames;
    ChatRoomManager chatRoomManager;
    
    public ChatRoom(){
        users = new ArrayList<>();
        messages = new ArrayList<>();
        chatRoomFrames = new ArrayList<>();
        
        //start chatroom manager frame
                java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatRoomManager(ChatRoom.this).setVisible(true);
            }
        });
    }
    
    public boolean sendMessage(Message m){
        messages.add(m);
       
        for (ChatRoomFrame frame: chatRoomFrames){
            if (frame.hasJoined()){
                frame.getChatRoomPanel().showMessage(m);
            }
        }
        
        return true;
    }
    
    public void userStart(){
            java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChatRoomFrame newFrame = new ChatRoomFrame(ChatRoom.this);
                newFrame.setVisible(true);
                ChatRoom.this.chatRoomFrames.add(newFrame);
            }
        });
    }
    
    public boolean userJoin(User u){
        users.add(u);
        return true;
    }
    
    public void userLeave(User u, ChatRoomFrame frame){
        chatRoomFrames.remove(frame);
        
        if (u != null){
            users.remove(u);
        }
    }
    
    public void updateMessageLog(){
        //update message log
        
    }
    
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
    }
    
}
