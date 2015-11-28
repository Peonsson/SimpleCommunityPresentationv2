package Beans;

import BusinessLogic.PrivateMessageHandler;
import Entity.PrivateMessage;

import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by robin on 19/11/15.
 */
@ManagedBean(name = "ReadPrivateMessage")
public class ReadPrivateMessageBean {
    public List<PrivateMessage> messages;

    public ReadPrivateMessageBean() {
        super();
    }

    public List<PrivateMessage> getMessages() {
        messages = PrivateMessageHandler.fetchPrivateMessages();
        return messages;
    }

    public void setMessages(List<PrivateMessage> messages) {
        this.messages = messages;
    }
}
