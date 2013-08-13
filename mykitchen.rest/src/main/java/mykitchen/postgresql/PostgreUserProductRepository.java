package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.UserProduct;
import mykitchen.repositories.UserProductRepository;

@Stateless
public class PostgreUserProductRepository extends
		PostgreBaseRepository<UserProduct> implements UserProductRepository {

}
