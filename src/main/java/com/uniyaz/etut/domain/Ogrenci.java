package com.uniyaz.etut.domain;

import com.uniyaz.etut.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="OGRENCİ")
public class Ogrenci extends BaseDomain {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String ogrenciAd;

    @Column
    private Integer sinif;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public Integer getSinif() {
        return sinif;
    }

    public void setSinif(Integer sinif) {
        this.sinif = sinif;
    }

    @Override
    public String toString() {
        return  ogrenciAd ;
    }
}
