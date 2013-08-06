package mykitchen.business;

import java.util.List;

import mykitchen.model.UnitOfMeasure;

public interface UnitOfMeasureBean {

	List<UnitOfMeasure> getAll();

	UnitOfMeasure getUOM(Long id);

	int putUOM(UnitOfMeasure uom);
}
