package Repo;

import Entities.Rewards;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RewardRepo extends EntityRepo<Rewards>{
    public RewardRepo() {
        super(Rewards.class);
    }
}
