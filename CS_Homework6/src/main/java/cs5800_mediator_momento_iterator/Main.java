package cs5800_mediator_momento_iterator;

import java.util.Iterator;
import java.util.List;

public class Main {
    private static final ChatServer chatServer = new ChatServer();
    public static void main(String[] args) {
        //creating 4 users and adding them to system
        System.out.println("\n===== User Creation =====");
        User frnd1 = new User("Rucha Nandgirikar", chatServer);
        User frnd2 = new User("Triaksha Kalra", chatServer);
        User frnd3 = new User("Raashmi E", chatServer);
        User frnd4 = new User("Gokul S", chatServer);

        System.out.println();
        chatServer.sendMessage(new Message(frnd1, List.of(frnd2), "Hey, Triaksha! What are we having for dinner tonight!"));
        chatServer.sendMessage(new Message(frnd4, List.of(frnd2), "Hi Triaksha, How was your class today"));
        chatServer.sendMessage(new Message(frnd2, List.of(frnd4), "Hey Rucha, Thanks for asking,today we have an extra class and class dinner after that"));
        chatServer.sendMessage(new Message(frnd4, List.of(frnd1), "Triaksha, Thanks for cooking rice for me "));
        chatServer.sendMessage(new Message(frnd1, List.of(frnd3), "Hi Gokul, What would you have with rice ?"));
        chatServer.sendMessage(new Message(frnd1, List.of(frnd4), "We are planning to order gravy "));
        chatServer.sendMessage(new Message(frnd3, List.of(frnd1), "Hello, Raashmi, I will not be eating rice today, will order something else"));

        System.out.println("\n===== Demonstrating block function =====");
        frnd2.blockerUsers(frnd1);
        System.out.println();
        chatServer.sendMessage(new Message(frnd1, List.of(frnd2, frnd3), "Gokul, I want to go to cheesecake factory!"));
        System.out.println();
        chatServer.sendMessage(new Message(frnd3, List.of(frnd1), "Why cheesecake factory, Rucha?"));
        System.out.println();
        System.out.println("\n===== Demonstrating unsent function =====");
        System.out.println("Raashmi E unsent last message");
        chatServer.undoLastMessage(frnd3);
        System.out.printf("Now, Raashmi E last message is '%s'\n", frnd3.getChatHistory().getLastSentMessages());
        System.out.println();
        System.out.println("\n===== Demonstrating unsent function =====");
        System.out.println("Triaksha Kalra unsent last message:");
        chatServer.undoLastMessage(frnd2);
        System.out.println();
        // Trying iterating over all messages in user3's chat history
        System.out.println("Iterating over all messages in Raashmi E chat history:");
        Iterator<Message> allMessagesIterator = frnd3.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.println();
        // Trying iterating over all messages in user1's chat history
        System.out.println("Iterating over all messages in Rucha Nandgirikar chat history:");
        allMessagesIterator = frnd1.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.println();
        // Trying iterating over all messages in user4's chat history
        System.out.println("Iterating over all messages in Gokul S chat history:");
        allMessagesIterator = frnd4.iterator();
        while (allMessagesIterator.hasNext()) {
            System.out.println(allMessagesIterator.next());
        }
        System.out.println();
        chatServer.unregisterUser(frnd1);
        chatServer.sendMessage(new Message(frnd3, List.of(frnd1),"Because I want to have the cheesecakes from there."));
    }
}