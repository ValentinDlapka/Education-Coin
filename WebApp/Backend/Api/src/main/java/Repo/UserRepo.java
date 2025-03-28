package Repo;

import Entities.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import web3J.BlockchainCommunication;

import java.util.Optional;

@ApplicationScoped
public class UserRepo extends EntityRepo<User> {
    @Inject
    BlockchainCommunication blockchain;

    public UserRepo() {
        super(User.class);
    }

    @Transactional
    public void add(User e) {
        if (!e.isTeacher()) {
            blockchain.createNewWallet(e);
        } else {
            //todo add school Wallet to teacher
        }
        super.add(e);
    }

    public Optional<User> findUserByName(String name) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.name = :name", User.class
        );
        query.setParameter("name", name);

        return query.getResultStream().findFirst();
    }
}
