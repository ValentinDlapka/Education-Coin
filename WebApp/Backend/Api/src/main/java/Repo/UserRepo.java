package Repo;

import Entities.User;

public class UserRepo extends EntityRepo<User> {
    public UserRepo() {
        super(User.class);
    }
}
