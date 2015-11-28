package Beans;

import BusinessLogic.UserHandler;
import Entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by robin on 13/11/15.
 */
@ManagedBean(name="UserBrowse")
@SessionScoped
public class UserBrowseBean {

    private List<User> users;

    public List<User> getUsers() {
        users = UserHandler.browse();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
