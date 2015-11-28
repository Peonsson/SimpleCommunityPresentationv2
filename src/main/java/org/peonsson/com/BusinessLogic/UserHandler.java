package org.peonsson.com.BusinessLogic;

import org.peonsson.com.Entity.User;
import org.peonsson.com.ViewModels.LoginViewModel;
import org.peonsson.com.ViewModels.ReturnCodeViewModel;
import org.peonsson.com.ViewModels.UserViewModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by robin on 9/11/15.
 */
@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserHandler {

    @POST
    @Path("/register")
    public static Response registerUser(User user) {
        System.out.println(user.toString());
        if(User.register(user)) {
            return Response.status(Response.Status.CREATED).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/login")
    public static ReturnCodeViewModel loginUser(LoginViewModel model) {
        System.err.println("suka");
        System.out.println("Usr handler: username = " + model.getUsername() + "\npassword = " + model.getPassword());

        int id = User.login(model);
        return new ReturnCodeViewModel(id);
    }

    @GET
    public static List<UserViewModel> getUsers() {
        return User.getUsers();
    }

    @GET
    @Path("/{id}")
    public static UserViewModel getUser(@PathParam("id") int id) {
        return User.getUserViewModel(id);
    }


    public static void addFriend(int userToAddAsFriend) {
        User.addFriend(userToAddAsFriend);
    }
}
