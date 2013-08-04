package mykitchen.postgresql;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import mykitchen.model.User;
import mykitchen.repositories.UserRepository;

@Stateless
public class PostgreUserRepository extends PostgreBaseRepository<User>
		implements UserRepository {

	@Override
	public User login(String username, String password) {
		TypedQuery<User> query = entityManager
				.createQuery(
						"SELECT u FROM User u WHERE u.username = :username AND u.password = :password",
						User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> resultList = query.getResultList();

		return resultList.isEmpty() ? new User() : resultList.get(0);
	}

}
