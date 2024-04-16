package cs5800_mediator_momento_iterator;

public class MessageMemento {
//    represents a snapshot of a message sent by a user
//    it should have properties for the message content and timestamp

    private Message message;

    MessageMemento(Message message){
        this.message = message;
    }

    public Message getPreviousMessage(){
        return message;
    }
}
