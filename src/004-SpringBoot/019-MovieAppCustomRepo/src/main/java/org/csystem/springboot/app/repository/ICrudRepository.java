package org.csystem.springboot.app.repository;

import java.util.Optional;

public interface ICrudRepository<T, ID> {
	<S extends T> S save(S t);
	Iterable<T> findAll();
	Optional<T> findById(ID id);
	void delete(T entity);
	boolean	existsById(ID id);
	long count();
	//...
}
