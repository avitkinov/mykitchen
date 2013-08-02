package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.User;
import mykitchen.repositories.UserRepository;

@Stateless
public class PostgreUserRepository extends PostgreBaseRepository<User> implements UserRepository{


}
