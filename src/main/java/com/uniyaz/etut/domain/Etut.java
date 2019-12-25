package com.uniyaz.etut.domain;

import com.uniyaz.etut.common.BaseDomain;
import com.uniyaz.etut.domain.enumPackage.EnumDers;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="ETUT")
public class Etut extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(length = 100)
    private String ogretmen;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private EnumDers enumDers;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(String ogretmen) {
        this.ogretmen = ogretmen;
    }

    public EnumDers getEnumDers() {
        return enumDers;
    }

    public void setEnumDers(EnumDers enumDers) {
        this.enumDers = enumDers;
    }

}
