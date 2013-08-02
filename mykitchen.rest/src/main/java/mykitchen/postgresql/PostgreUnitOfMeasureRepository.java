package mykitchen.postgresql;

import javax.ejb.Stateless;

import mykitchen.model.UnitOfMeasure;
import mykitchen.repositories.UnitOfMeasureRepository;

@Stateless
public class PostgreUnitOfMeasureRepository extends PostgreBaseRepository<UnitOfMeasure> implements UnitOfMeasureRepository{

	
}
