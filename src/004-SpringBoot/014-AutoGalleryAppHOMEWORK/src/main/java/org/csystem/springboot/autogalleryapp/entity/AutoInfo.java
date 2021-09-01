package org.csystem.springboot.autogalleryapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "autos")
@Accessors(prefix = "m_")
@Getter
@Setter
@NoArgsConstructor
public class AutoInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private long m_id;

    @Column(name = "make", nullable = false)
    private String m_make;

    @Column(name = "model", nullable = false)
    private String m_model;

    @Column(name = "model_year", nullable = false)
    private int m_modelYear;

    @Column(name = "km", nullable = false)
    private int m_km;

    @Column(name = "rent", nullable = false)
    private boolean m_rent;

    @JsonIgnore
    public long getId()
    {
        return m_id;
    }
}
