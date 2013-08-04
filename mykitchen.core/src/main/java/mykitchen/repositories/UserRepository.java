package mykitchen.repositories;

import mykitchen.model.User;

public interface UserRepository extends BaseRepository<User> {

	User login(String username, String password);
}
