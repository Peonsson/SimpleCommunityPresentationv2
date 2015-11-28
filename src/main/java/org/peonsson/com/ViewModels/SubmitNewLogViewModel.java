package org.peonsson.com.ViewModels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Peonsson on 27/11/15.
 */
@XmlRootElement
public class SubmitNewLogViewModel {

    private int id;
    private String message;
    private String subject;

    public SubmitNewLogViewModel() {
    }

    public SubmitNewLogViewModel(int id, String message, String subject) {
        this.id = id;
        this.message = message;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
