package cs5800_mediator_momento_iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user1;
    private User user2;
    private User user3;

    private ChatServer chatServer = new ChatServer();

    @Before
    public void setUp() {
        user1 = new User("Alice",chatServer);
        user2 = new User("Bob",chatServer);
        user3 = new User("Eve",chatServer);
    }

    @Test
    public void testBlockerUsers() {
        user1.blockerUsers(user2);
        assertTrue(user1.getBlockedUsers().contains(user2));
    }

    @Test
    public void testBlockUserNotRegistered() {
        user1.blockerUsers(user3); // Eve is not registered
        assertEquals(1, user1.getBlockedUsers().size());
    }

    @Test
    public void testSetBlockUsers() {
        user1.setBlockUsers(user2);
        assertTrue(user1.getBlockedUsers().contains(user2));
    }

    @Test
    public void testSetBlockAlreadyBlocked() {
        user1.setBlockUsers(user2);
        user1.setBlockUsers(user2); // Trying to block already blocked user
        assertEquals(1, user1.getBlockedUsers().size());
    }

    @Test
    public void testSetBlockUserNotRegistered() {
        user1.setBlockUsers(user3); // Eve is not registered
        assertEquals(1, user1.getBlockedUsers().size());
    }


}