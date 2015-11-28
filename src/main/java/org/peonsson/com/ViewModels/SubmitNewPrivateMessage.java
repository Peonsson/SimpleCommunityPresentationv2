package org.peonsson.com.ViewModels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Peonsson on 27/11/15.
 */
@XmlRootElement
public class SubmitNewPrivateMessage {

    private int sender;
    private String message;
    private String subject;

    public SubmitNewPrivateMessage() {
    }

    public SubmitNewPrivateMessage(int sender, String message, String subject) {
        this.sender = sender;
        this.message = message;
        this.subject = subject;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
