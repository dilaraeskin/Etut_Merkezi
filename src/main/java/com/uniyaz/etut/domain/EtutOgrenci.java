package com.uniyaz.etut.domain;

import com.uniyaz.etut.common.BaseDomain;

import javax.persistence.*;

@Entity
@Table(name="ETUTOGRENCİ")
public class EtutOgrenci extends BaseDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_OGRENCİ", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FOREIGN_OGRENCİ_ID"))
    private Ogrenci ogrenci;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ETUT", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FOREIGN_ETUT_ID"))
    private Etut etut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Etut getEtut() {
        return etut;
    }

    public void setEtut(Etut etut) {
        this.etut = etut;
    }
}
