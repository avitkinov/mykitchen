package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.Product;
import mykitchen.repositories.ProductRepository;

@Stateless
public class PostgreProductRepository extends PostgreBaseRepository<Product> implements ProductRepository{



}
