package org.csystem.springboot.app.repository;

import org.csystem.springboot.app.entity.MovieInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class MovieRepository implements IMovieRepository {
    @PersistenceContext
    private EntityManager m_entityManager;

    @Override
    public Iterable<MovieInfo> findByYear(int year)
    {
        var query = m_entityManager.createNativeQuery("select * from movies where date_part('year', date)=?");

        query.setParameter(1, year);

        return query.getResultList();
    }

    @Override
    public Iterable<MovieInfo> findByYears(int start, int end)
    {
        var query = m_entityManager.createNativeQuery("select * from movies where date_part('year', date) between ? and ?");

        query.setParameter(1, start);
        query.setParameter(2, end);

        return query.getResultList();
    }

    @Override
    public Iterable<MovieInfo> findByNameStartsWith(String name)
    {
        var query = m_entityManager.createQuery("select mi from MovieInfo mi where mi.m_name like ?1");

        query.setParameter(1, name + "%");

        return query.getResultList();
    }

    @Override
    public Iterable<MovieInfo> findByNameContaining(String name)
    {
        var query = m_entityManager.createQuery("select mi from MovieInfo mi where mi.m_name like ?1");

        query.setParameter(1, "%" + name + "%");

        return query.getResultList();
    }

    @Override
    public <S extends MovieInfo> S save(S t)
    {
        m_entityManager.persist(t);

        return t;
    }

    @Override
    public Iterable<MovieInfo> findAll()
    {
        var query = m_entityManager.createQuery("select mi from MovieInfo mi");

        return  query.getResultList();
    }

    @Override
    public Optional<MovieInfo> findById(Long id)
    {
        var query = m_entityManager.createQuery("select mi from MovieInfo mi where mi.m_id=?1");

        query.setParameter(1, id);

        return query.getResultStream().findFirst();
    }

    @Override
    public void delete(MovieInfo entity)
    {
        //...
    }

    @Override
    public boolean existsById(Long aLong)
    {
        return false;
    }

    @Override
    public long count()
    {
        /*
        var nativeQuery = m_entityManager.createNativeQuery("select count(*) from movies");

        return nativeQuery.getResultList().stream().findFirst()
        */

        var query = m_entityManager.createQuery("select mi from MovieInfo mi");

        return query.getResultStream().count();

    }
}
