package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by robin on 9/11/15.
 */
@ManagedBean(name = "User")
@SessionScoped
public class UserBean {
    private int userId;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String country;
    private String city;

    public UserBean() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public void register() {
//        boolean registerSuccess = UserHandler.registerUser(email, username, password, firstname, lastname, country, city);
//
//        if (registerSuccess) {
//            try {
//                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//                ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
//            } catch (IOException e) {
//                System.out.println("failed redirecting");
//                e.printStackTrace();
//            }
//        } else {
//            // TODO: Assign variable if registration failed. (http://stackoverflow.com/questions/15452539/redirecting-form-jsf-managed-bean-and-showing-js-alert-based-on-condition-in-man)
//        }
//    }
}
