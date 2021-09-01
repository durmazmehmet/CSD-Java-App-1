package org.csystem.repository;

import java.util.Optional;

public interface IRepository<T, ID> {
	<S extends T> S save(S t);
	Iterable<? extends T> findAll();
	Optional<T> findById(ID id);
	void delete(T entity);
	boolean	existsById(ID id);
	long count();
	//...
}
