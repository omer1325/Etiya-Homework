package ReCapProject.dataAccess.abstracts;

import java.util.List;

public interface DaoRepository<T> {
	
	void add(T entity);
	void remove(T entity);
	void update(int id,T entity);
	T getById(int id);
	List<T> getAll();
	

}
