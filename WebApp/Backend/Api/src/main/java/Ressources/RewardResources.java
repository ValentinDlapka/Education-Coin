package Ressources;

import Entities.Rewards;
import Repo.RewardRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/rewards")
public class RewardResources {
    @Inject
    private RewardRepo rewardRepo;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rewards> getAllRewards() {
        return rewardRepo.getAll();
    }
}

