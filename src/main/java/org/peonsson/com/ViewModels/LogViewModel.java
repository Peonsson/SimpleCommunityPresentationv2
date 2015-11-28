package org.peonsson.com.ViewModels;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Peonsson on 27/11/15.
 */
@XmlRootElement
public class LogViewModel {
    private String message;
    private String subject;
    private Date timestamp;
    private String username;

    public LogViewModel() {
    }

    public LogViewModel(String message, String subject, Date timestamp, String username) {
        this.message = message;
        this.subject = subject;
        this.timestamp = timestamp;
        this.username = username;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
