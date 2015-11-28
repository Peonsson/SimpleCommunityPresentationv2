package org.peonsson.com.BusinessLogic;


import org.peonsson.com.Entity.PrivateMessage;
import org.peonsson.com.ViewModels.PrivateMessageViewModel;
import org.peonsson.com.ViewModels.ReturnBooleanViewModel;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Peonsson on 19/11/15.
 */
@Path("/PrivateMessages")
@Produces("application/json")
@Consumes("application/json")
public class PrivateMessageHandler {

    @POST
    public static ReturnBooleanViewModel submit(PrivateMessageViewModel privateMessage) {
        boolean bool = PrivateMessage.submit(privateMessage);
        return new ReturnBooleanViewModel(bool);
    }

    @GET
    @Path("/{id}")
    public static List<PrivateMessageViewModel> fetchPrivateMessages(@PathParam("id") int id) {
        return PrivateMessage.fetchPrivateMessages(id);
    }
}
