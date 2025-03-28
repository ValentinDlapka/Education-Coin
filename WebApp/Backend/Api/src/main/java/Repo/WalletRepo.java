package Repo;

import Entities.Wallet;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepo extends EntityRepo<Wallet> {
    public WalletRepo() {
        super(Wallet.class);
    }
}
