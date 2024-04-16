package cs5800_mediator_momento_iterator;
import java.util.Date;
import java.util.List;

public class Message {

    private User sender;
    private List<User> recipients;

    private String messageContent;

    private Date timestamp;

    public Message(User sender, List<User> recipients, String messageContent) {
        this.sender = sender;
        this.recipients = recipients;
        this.messageContent = messageContent;
        this.timestamp = new Date();
    }


    public MessageMemento saveToMemento(){
        return new MessageMemento(this);
    }

    public void restoreFromMemento(MessageMemento messageMemento){
        Message previousMessage = messageMemento.getPreviousMessage();
        this.sender = previousMessage.getSender();
        this.recipients = previousMessage.getRecipients();
        this.messageContent = previousMessage.getMessageContent();
        this.timestamp = previousMessage.getTimestamp();
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recepients) {
        this.recipients = recepients;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String toString(){
        return String.format("%s: Message content: '%s'",
                timestamp.toString(), messageContent);
    }

}
