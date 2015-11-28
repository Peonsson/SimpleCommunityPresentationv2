package org.peonsson.com.ViewModels;

/**
 * Created by Peonsson on 27/11/15.
 */
public class LoginViewModel {

    private String username;
    private String password;

    public LoginViewModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
