package Ressources;

import DTO.RewardDTO;
import Entities.Rewards;
import Repo.RewardRepo;
import Repo.UserRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import web3J.BlockchainCommunication;

import java.math.BigInteger;
import java.util.List;

@ApplicationScoped
@Path("/rewards")
public class RewardResources {
    @Inject
    private RewardRepo rewardRepo;
    @Inject
    private UserRepo userRepo;
    @Inject
    private BlockchainCommunication blockchain;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRewards() {
        return Response.ok(rewardRepo.getAll()).build();
    }
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response redeemReward(@PathParam("id") Long id, Long userID) {
        try {
            TransactionReceipt transaction =  blockchain.redeemTokens(BigInteger.valueOf(rewardRepo.get(id).getPrice()),userRepo.get(userID).getWallet().getAddress());
            return Response.ok(transaction).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
         return Response.serverError().build();
        }
    }
    @POST
    @Path("/redeem/{student}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response redeemStudentReward(@PathParam("student") Long student, RewardDTO rewardDTO) {
        try {
            TransactionReceipt transactionReceipt = blockchain.distributeTokens(userRepo.get(student).getWallet().getAddress(),BigInteger.valueOf(rewardDTO.amount), rewardDTO.test, rewardDTO.grade);
            return Response.ok(transactionReceipt).build();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}

