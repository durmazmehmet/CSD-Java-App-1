package org.csystem.springboot.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_informations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_info_id")
    private long id;

    @Column(name = "host_addr", nullable = false)
    private String hostAddr;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "query_date_time", nullable = false)
    private LocalDateTime queryDateTime = LocalDateTime.now();

    public ClientInfo(String hostAddr, String postalCode, String country)
    {
        this.hostAddr = hostAddr;
        this.postalCode = postalCode;
        this.country = country;
    }
}
