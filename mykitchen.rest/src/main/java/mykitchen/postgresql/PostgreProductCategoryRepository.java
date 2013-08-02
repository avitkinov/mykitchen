package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.ProductCategory;
import mykitchen.repositories.ProductCategoryRepository;

@Stateless
public class PostgreProductCategoryRepository extends PostgreBaseRepository<ProductCategory> implements ProductCategoryRepository{

}
