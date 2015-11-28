package Beans;

import BusinessLogic.PrivateMessageHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Peonsson on 19/11/15.
 */

@ManagedBean(name="SendPrivateMessage")
@RequestScoped
public class SendPrivateMessageBean {

    private String subject;
    private String message;
    private String sender;
    private String receiver;

    public SendPrivateMessageBean() {
    }

    public String submit(String sender, String receiver) {

        System.out.println("SendPrivateMessageBean.. submit.. receiver: " + receiver);
        System.out.println("SendPrivateMessageBean.. submit.. sender: " + sender);
        System.out.println("SendPrivateMessageBean.. submit.. subject: " + subject);
        System.out.println("SendPrivateMessageBean.. submit.. message: " + message);

        PrivateMessageHandler.submit(sender, receiver, subject, message);

        return "profile.xhtml";
    }

    public String sendPm() {
        return "sendpm.xhtml";
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

}
