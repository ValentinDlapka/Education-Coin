package Ressources;

import Entities.Rewards;
import Repo.RewardRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import web3J.BlockchainCommunication;

import java.math.BigInteger;
import java.util.List;

@ApplicationScoped
@Path("/rewards")
public class RewardResources {
    @Inject
    private RewardRepo rewardRepo;
    @Inject
    private BlockchainCommunication blockchain;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rewards> getAllRewards() {
        return rewardRepo.getAll();
    }
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void redeemReward(@PathParam("id") Long id) {
        Rewards reward = rewardRepo.get(id);
        try {
            blockchain.redeemTokens(BigInteger.valueOf(reward.getPrice()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

