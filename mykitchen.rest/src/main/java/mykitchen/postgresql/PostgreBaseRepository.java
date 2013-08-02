package mykitchen.postgresql;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import mykitchen.repositories.BaseRepository;

public class PostgreBaseRepository<T> implements BaseRepository<T> {

	@PersistenceContext(unitName = "jdbc/mykitchen", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	public List<T> getAll() {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) (getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];

		TypedQuery<T> query = entityManager.createQuery("SELECT e FROM "
				+ clazz.getSimpleName() + " e", clazz);

		return query.getResultList();
	}

	public T find(Object id) {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) (getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];
		
		return entityManager.find(clazz, id);
	}

	public void add(T entity) {
		entityManager.persist(entity);
	}

	public void edit(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

}
