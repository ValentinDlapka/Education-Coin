package Ressources;

import DTO.UserDTO;
import Entities.User;
import Repo.UserRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
@Path("/user")
public class UserResource {
    @Inject
    private UserRepo userRepo;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(UserDTO user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setHashedPassword(user.getPassword());
        newUser.setTeacher(user.isTeacher());
        userRepo.add(newUser);
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserDTO userDTO) {
        Optional<User> user = userRepo.findUserByName(userDTO.getName());
        if(user.isPresent()) {
            if (user.get().checkPassword(userDTO.getPassword())) {
                UserDTO userResponse = new UserDTO(user.get().getId(),user.get().getName(),"", user.get().isTeacher());
                return Response.ok(userResponse).build();
            }
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
