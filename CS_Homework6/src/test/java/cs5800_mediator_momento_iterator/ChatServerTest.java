package cs5800_mediator_momento_iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChatServerTest {

    private ChatServer chatServer;

    @Before
    public void setUp() {
        chatServer = new ChatServer();
    }
    @Test
    public void testRegisterUser() {
        User user = new User("Alice",chatServer);
        chatServer.registerUser(user);
        assertTrue(chatServer.getUsers().contains(user));
    }

    @Test
    public void testRegisterMultipleUsers() {
        User user1 = new User("Alice",chatServer);
        User user2 = new User("Bob",chatServer);
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        assertTrue(chatServer.getUsers().contains(user1));
        assertTrue(chatServer.getUsers().contains(user2));
    }


    @Test
    public void testUnregisterUser() {
        User user = new User("Alice",chatServer);
        chatServer.registerUser(user);
        chatServer.unregisterUser(user);
        assertTrue(chatServer.getUsers().contains(user));
    }

    @Test
    public void testUnregisterNonExistentUser() {
        int initialSize = chatServer.getUsers().size();
        User user = new User("Alice",chatServer);
        chatServer.unregisterUser(user); // Trying to unregister a user that was never registered
        assertEquals(initialSize, chatServer.getUsers().size());
    }

    @Test
    public void testUnregisterMultipleUsers() {
        User user1 = new User("Alice",chatServer);
        User user2 = new User("Bob",chatServer);
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.unregisterUser(user1);
        chatServer.unregisterUser(user2);
        assertTrue(chatServer.getUsers().contains(user1));
        assertTrue(chatServer.getUsers().contains(user2));
    }
}