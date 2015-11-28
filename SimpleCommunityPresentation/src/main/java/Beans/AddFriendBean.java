package Beans;

import BusinessLogic.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Peonsson on 19/11/15.
 */
@ManagedBean(name="AddFriend")
@SessionScoped
public class AddFriendBean {

    public AddFriendBean() {
    }

    public void addFriend(String userToAddAsFriend) {
        UserHandler.addFriend(Integer.parseInt(userToAddAsFriend));
    }
}
