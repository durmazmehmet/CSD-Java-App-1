package org.csystem.springboot.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movies")
@Accessors(prefix = "m_")
@Setter
@Getter
public class MovieInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private long m_id;

    @Column(name="name", nullable = false)
    private String m_name;

    @Column(name="type", nullable = false)
    private String m_type;

    @Column(name="date", nullable = false)
    private LocalDate m_date;

    @Column(name="director", nullable = false)
    private String m_director;

    @Column(name="duration", nullable = false)
    private double m_duration;

    public MovieInfo() {}

    public MovieInfo(String name, String type, LocalDate date, String director, double duration)
    {
        m_name = name;
        m_type = type;
        m_date = date;
        m_director = director;
        m_duration = duration;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getType()
    {
        return m_type;
    }

    public void setType(String type)
    {
        m_type = type;
    }

    public void setDate(LocalDate date)
    {
        m_date = date;
    }

    public String getDirector()
    {
        return m_director;
    }

    public void setDirector(String director)
    {
        m_director = director;
    }

    public double getDuration()
    {
        return m_duration;
    }

    public void setDuration(double duration)
    {
        m_duration = duration;
    }

    public LocalDate getDate()
    {
        return m_date;
    }
}
