package org.peonsson.com.Entity;

import org.peonsson.com.Database.PrivateMessageDB;
import org.peonsson.com.Database.UserDB;
import org.peonsson.com.ViewModels.PrivateMessageViewModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by Peonsson and roppe546.
 *
 * This class represents a log entry that a user writes.
 */

@Entity
@Table(name = "PrivateMessage")
@XmlRootElement
public class PrivateMessage {
    @Column(name = "PrivateMessageId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int privateMessageId;

//    @Column(name = "Sender")
    @ManyToOne
    @JoinColumn(name = "Sender")
    @NotNull
    private User sender;

//    @Column(name = "Receiver")
    @ManyToOne
    @JoinColumn(name = "Receiver")
    @NotNull
    private User receiver;

    @Column(name = "Timestamp")
    @NotNull
    private Date timestamp;

    @Column(name = "Subject")
    @NotNull
    @Size(min = 3, max = 32, message = "Subject must be between 3 to 32 characters long.")
    private String subject;

    @Column(name = "Message")
    @NotNull
    @Size(min = 3, max = 128, message = "Message must be between 3 to 128 characters long.")
    private String message;

    @Column(name = "IsRead")
    @NotNull
    private boolean isRead;

    public PrivateMessage() {
        super();
    }

    /**
     * Constructor used to create a new PrivateMessage.
     *
     * @param sender    the user who sent the message
     * @param receiver  the user to receive the message
     * @param subject   the subject of the message
     * @param message   the message itself
     */
    public PrivateMessage(User sender, User receiver, String subject, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = new Date();
        this.subject = subject;
        this.message = message;
        this.isRead = false;
    }

    public int getPrivateMessageId() {
        return privateMessageId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "PrivateMessage{" +
                "privateMessageId=" + privateMessageId +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", timestamp=" + timestamp +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                '}';
    }

    public static boolean submit(PrivateMessageViewModel privateMessage) {

        int senderId = Integer.parseInt(privateMessage.getSender());
        int receiverId = Integer.parseInt(privateMessage.getReceiver());

        User sender = UserDB.getUser(senderId);
        User receiver = UserDB.getUser(receiverId);

        if (sender != null && receiver != null) {
            System.out.println("PrivateMessage: Sender: " + sender.toString());
            System.out.println("PrivateMessage: Receiver: " + receiver.toString());

            PrivateMessage pm = new PrivateMessage(sender, receiver, privateMessage.getSubject(), privateMessage.getMessage());

            return PrivateMessageDB.submit(pm);
        }
        else {
            System.out.println("SENDER OR RECEIVER NULL");
            return false;
        }
    }



    public static List<PrivateMessageViewModel> fetchPrivateMessages(int id) {
        // TODO: MOVE TO CORRECT LOCATION (SHOULD BE IN PRESENTATION NOT MODEL)
//        int userId = (Integer) SessionBean.getSession().getAttribute("userId");

        User user = UserDB.getUser(id);
        return PrivateMessageDB.fetchPrivateMessages(user);
    }
}
