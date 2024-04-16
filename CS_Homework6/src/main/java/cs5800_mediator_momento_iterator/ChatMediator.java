package cs5800_mediator_momento_iterator;

interface ChatMediator {
        void sendMessage(Message message);
        void registerUser(User user);
        void unregisterUser(User user);
        void blockMessages(String blocker, String blockee);
    }

