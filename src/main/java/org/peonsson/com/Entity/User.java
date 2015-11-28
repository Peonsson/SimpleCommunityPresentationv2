package org.peonsson.com.Entity;

import org.peonsson.com.Database.UserDB;
import org.peonsson.com.ViewModels.LoginViewModel;
import org.peonsson.com.ViewModels.UserViewModel;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Peonsson and roppe546.
 * <p>
 * This class describes user entities in database.
 */

@Entity
@Table(name = "User")
public class User {
    @Column(name = "UserId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "Email", unique = true)
    @NotNull
    private String email;

    @Column(name = "Username", unique = true)
    @NotNull
    @Min(value = 3, message = "Username must be at least 3 characters long.")
    @Max(value = 32, message = "Username cannot be longer than 32 characters.")
    private String username;

    @Column(name = "Password")
    @Min(value = 3, message = "Password must be at least 3 characters long.")
    @Max(value = 128, message = "Password cannot be longer than 128 characters.")
    private String password;

    @Column(name = "Firstname")
    @NotNull
    @Min(value = 2, message = "First name must be at least 2 characters long.")
    @Max(value = 32, message = "First name cannot be longer than 32 characters.")
    private String firstname;

    @Column(name = "Lastname")
    @NotNull
    @Min(value = 2, message = "Last name must be at least 2 characters long.")
    @Max(value = 32, message = "Last name cannot be longer than 32 characters.")
    private String lastname;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    // This users friends (other users)
    @ManyToMany
    @JoinTable(name = "Friends", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "FriendUserId"))
    private List<User> friends;

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<User> friendOf) {
        this.friendOf = friendOf;
    }

    // Other users who have this user as friend
    @ManyToMany
    @JoinTable(name = "FriendOf", joinColumns = @JoinColumn(name = "UserId"), inverseJoinColumns = @JoinColumn(name = "FriendUserId"))
    private List<User> friendOf;

    public User() {
        super();
    }

    /**
     * Constructor used to create a user object.
     *
     * @param email     users email address
     * @param username  username
     * @param password  password
     * @param firstname users first name
     * @param lastname  users last name
     * @param country   country where user lives
     * @param city      city where user lives
     */
    public User(String email, String username, String password, String firstname, String lastname, String country, String city) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.city = city;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
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

    public static boolean register(User user) {
        return UserDB.registerUser(user);
    }

    public static int login(LoginViewModel model) {
        User user = UserDB.loginUser(model);

        if (user != null) {
            if (user.username.equals(model.getUsername()) && user.password.equals(model.getPassword())) {
                System.out.println("User: have successfully logged in!");
                return user.getUserId();
            }
        }
        System.err.println("User: login failed.");
        return -1;
    }

    public static List<UserViewModel> getUsers() {
        return UserDB.getUsers();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static UserViewModel getUserViewModel(int id) {
        return UserDB.getUserViewModel(id);
    }

    public static void addFriend(int userToAddAsFriend) {
        // TODO: MOVE TO CORRECT LOCATION (SHOULD BE IN PRESENTATION NOT MODEL)
//        int userId = (Integer)SessionBean.getSession().getAttribute("userId");
        int userId = 1;
//        User myself = User.getUser(userId);
//        User otherUser = User.getUser(userToAddAsFriend);

//        System.out.println("Myself id : " + myself.getUserId());
        System.out.println("Member to add as friend : " + userToAddAsFriend);

//        UserDB.addFriend(myself, otherUser);
//        User friend = User.getUser(friendId);
//        myself.getFriends(friend);

    }
}