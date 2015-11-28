package Beans;


import BusinessLogic.LogHandler;
import Entity.UserLog;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peonsson on 11/11/15.
 */
@ManagedBean(name="Log")
@SessionScoped
public class LogBean {

    private String subject;
    private String message;
    private int userId;
    private List<UserLog> logs = new ArrayList<UserLog>();

    public LogBean() {
        super();
    }

    public void submit() {
        int userId = (Integer) SessionBean.getSession().getAttribute("userId");
        LogHandler.submit(userId, subject, message);
    }

    public List<UserLog> getLogs() {
        return LogHandler.fetchLogs();
    }

    public void setLogs(List<UserLog> logs) {
        this.logs = logs;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
