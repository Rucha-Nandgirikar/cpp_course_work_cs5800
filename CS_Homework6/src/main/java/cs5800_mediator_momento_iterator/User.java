package cs5800_mediator_momento_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User implements Iterable<Message>, IterableByUser {
//    sendMessage to other users
//    undo the last message sent
    private String username;
    private ChatServer chatServer;
    private  ChatHistory chatHistory;
    private List<MessageMemento> messageMementos;
    private List<User> blockedUsers;

    public User(String username, ChatServer chatServer){
        this.username = username;
        this.chatServer = chatServer;
        chatServer.registerUser(this);
        this.chatHistory = new ChatHistory();
        this.messageMementos = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

//    undo last message
public void undoLastSentMessage()
{
    List<Message> sentMessages = chatHistory.getSentMessages();
    Message lastMessage = sentMessages.get(sentMessages.size() - 1);
    chatHistory.removeLastSentMessage(lastMessage);
    MessageMemento messageMemento = lastMessage.saveToMemento();
    lastMessage.restoreFromMemento(messageMemento);
    sentMessages.remove(lastMessage);

}
    public void sendMessage(Message message){
        this.chatHistory.addSentMessage(message);
    }


    public void receiveMessage(Message message){
        this.chatHistory.addReceivedMessage(message);
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void blockerUsers(User blockedUser){
        List<User> users = chatServer.getUsers();
        if (!users.contains(this)){
            System.out.printf("User %s is not registered\n", username);
            return;
        } else if (!users.contains(blockedUser)){
            System.out.printf("User %s is not registered\n", blockedUser.getUsername());
            return;
        }
        setBlockUsers(blockedUser);
    }

    public void setBlockUsers(User blockedUser){
        if (blockedUsers != null && blockedUsers.contains(blockedUser)){
            System.out.println("User " + blockedUser.getUsername() + " has already blocked user " + blockedUser.getUsername());
        } else {
            blockedUsers.add(blockedUser);
            System.out.println("User " + username + " has blocked user " + blockedUser.getUsername());
        }
    }

    public List<User> getBlockedUsers(){
        return blockedUsers;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    @Override
    public Iterator<Message> iterator() {
        return chatHistory.iterator();
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }

}
