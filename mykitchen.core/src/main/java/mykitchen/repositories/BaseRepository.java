package mykitchen.repositories;

import java.util.List;

public interface BaseRepository<T> {

	List<T> getAll();
	
	T find(Object id);
	
	void add(T entity);
	
	void edit(T entity);
	
	void delete(T entity);
	
}
