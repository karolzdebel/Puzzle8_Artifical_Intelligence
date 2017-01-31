/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;

/**
 *
 * @author K
 */
public class ChatRoomFrame extends javax.swing.JFrame {

    private static String CHATROOM_PANEL = "CHATROOM_PANEL";
    private static String USER_REGISTER_PANEL = "USER_REGISTER_PANEL";
    private ChatRoomPanel chatRoomPanel;
    private UserRegisterPanel userRegisterPanel;
    private JPanel mainPanel;
    private CardLayout mainCardLayout;
    private ChatRoom chatRoom;
    private User user;
    private boolean joined; 
    

    /**

* Creates new form ChatRoomFrame
     */
    public ChatRoomFrame(ChatRoom chatRoom) {
        
        joined = false;
        user = null;
        this.chatRoom = chatRoom;
        
        chatRoomPanel = new ChatRoomPanel(this);
        userRegisterPanel = new UserRegisterPanel(this);
        mainPanel = new JPanel();
        mainCardLayout = new CardLayout();
        
        mainPanel.setLayout(mainCardLayout);
        mainPanel.add(userRegisterPanel,USER_REGISTER_PANEL);
        mainPanel.add(chatRoomPanel,CHATROOM_PANEL);
        this.add(mainPanel);
        this.pack();
        
        mainCardLayout.show(mainPanel, USER_REGISTER_PANEL);
        
        //When window is closed, remove user from chat room
        this.addWindowListener(new WindowAdapter(){
            
            @Override
            public void windowClosing(WindowEvent e){
                chatRoom.userLeave(user, ChatRoomFrame.this);
            }
            
        });
      
    }

    public boolean hasJoined(){
        return joined;
    }
    
    public void sendMessage(String input){
        Message message = new Message(input,user);
        chatRoom.sendMessage(message);
    }
    
    public void addUser(String nickname, int age, char gender){
        User newUser = new User(nickname,gender,age);
        user = newUser;
        chatRoom.userJoin(newUser);
        this.setTitle(newUser.getNickname());
    }
    
    public ChatRoomPanel getChatRoomPanel(){
        return chatRoomPanel;
    }
    
    public void goToChatRoom(){
        joined = true;
        mainCardLayout.show(mainPanel,CHATROOM_PANEL);
    }
    
    public void goToUserReigster(){
        mainCardLayout.show(mainPanel,USER_REGISTER_PANEL);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(240, 400));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}