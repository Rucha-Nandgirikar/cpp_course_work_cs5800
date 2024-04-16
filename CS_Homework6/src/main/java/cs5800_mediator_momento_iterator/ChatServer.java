package cs5800_mediator_momento_iterator;

import java.util.*;


public class ChatServer implements ChatMediator {
//    This is a mediator class. It will manage communication between users
//    register and unregister users
//    send messages from one user to one or more other users
//    block messages from specific users

    private List<User> users;
    public ChatServer(){
        users = new ArrayList<>();
    }

    @Override
    public void sendMessage(Message message) {
        User sender = message.getSender();
        List<User> receivers = new ArrayList<>(message.getRecipients());
        if(!users.contains(sender)){
            System.out.printf("Cannot send message as user %s is not registered.\n", sender.getUsername());
            return;
        }
        List<User> validReceivers = new ArrayList<>();
        for (User user : receivers){
            if (!users.contains(user)){
                System.out.printf("Cannot send message from %s to %s as user %s is not registered.\n", sender.getUsername(), user.getUsername(), user.getUsername());
            }
            else {
                validReceivers.add(user);
            }
        }
        for (User receiver : validReceivers){
            List<User> blockedAccounts = receiver.getBlockedUsers();
            if (blockedAccounts != null && blockedAccounts.contains(sender)){
                System.out.println("Cannot send message from " + sender.getUsername() + " to " + receiver.getUsername() +
                        " because " + sender.getUsername() + " is blocked by " + receiver.getUsername() + ".");
            } else{
                sender.sendMessage(message);
                System.out.printf("Successfully sent message from %s to %s\n", sender.getUsername(), receiver.getUsername());
                receiver.receiveMessage(message);
                System.out.printf("%s: %s received message from %s: '%s'\n", message.getTimestamp(),
                        receiver.getUsername(), sender.getUsername(), message.getMessageContent());
            }
        }
    }

    public void registerUser(User user) {
    users.add(user);
    System.out.printf("Successfully registered user %s\n", user.getUsername());
    }
    public void unregisterUser(User user) {
        users.remove(user);
        System.out.printf("Unregistered user %s\n", user.getUsername());
    }

    @Override
    public void blockMessages(String blocker, String blockee) {

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void undoLastMessage(User user){
        List<Message> sentMessages = user.getChatHistory().getSentMessages();
        if (sentMessages.size() == 0){
            System.out.printf("Cannot un-send last message as user %s has not sent any messages.\n", user.getUsername());
            return;
        }
        Message message = user.getChatHistory().getLastSentMessages();
        user.undoLastSentMessage();
        List<User> receivers = message.getRecipients();
        for (User receiver : receivers){
            receiver.getChatHistory().removeLastReceivedMessage(message);
        }
    }

}

