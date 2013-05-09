/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "OVEJA")
@NamedQueries({
    @NamedQuery(name = "Oveja.findAll", query = "SELECT o FROM Oveja o"),
    @NamedQuery(name = "Oveja.findByOvejaid", query = "SELECT o FROM Oveja o WHERE o.ovejaid = :ovejaid"),
    @NamedQuery(name = "Oveja.findByOvejarp", query = "SELECT o FROM Oveja o WHERE o.ovejarp = :ovejarp"),
    @NamedQuery(name = "Oveja.findByMajadaid", query = "SELECT o FROM Oveja o WHERE o.majadaid = :majadaid"),
    @NamedQuery(name = "Oveja.findByCorralid", query = "SELECT o FROM Oveja o WHERE o.corralid = :corralid"),
    @NamedQuery(name = "Oveja.findByOvejafechaalta", query = "SELECT o FROM Oveja o WHERE o.ovejafechaalta = :ovejafechaalta"),
    @NamedQuery(name = "Oveja.findByOvejapeso", query = "SELECT o FROM Oveja o WHERE o.ovejapeso = :ovejapeso"),
    @NamedQuery(name = "Oveja.findByOvejasexo", query = "SELECT o FROM Oveja o WHERE o.ovejasexo = :ovejasexo"),
    @NamedQuery(name = "Oveja.findByOvejaedadinicial", query = "SELECT o FROM Oveja o WHERE o.ovejaedadinicial = :ovejaedadinicial")})
public class Oveja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OVEJAID")
    private Integer ovejaid;
    @Basic(optional = false)
    @Column(name = "OVEJARP")
    private int ovejarp;
    @Basic(optional = false)
    @Column(name = "MAJADAID")
    private int majadaid;
    @Basic(optional = false)
    @Column(name = "CORRALID")
    private int corralid;
    @Basic(optional = false)
    @Column(name = "OVEJAFECHAALTA")
    @Temporal(TemporalType.DATE)
    private Date ovejafechaalta;
    @Column(name = "OVEJAPESO")
    private BigDecimal ovejapeso;
    @Basic(optional = false)
    @Column(name = "OVEJASEXO")
    private String ovejasexo;
    @Basic(optional = false)
    @Column(name = "OVEJAEDADINICIAL")
    private int ovejaedadinicial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oveja")
    private Collection<Criaxestadoxparto> criaxestadoxpartoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oveja")
    private Collection<Madrexestadoxparto> madrexestadoxpartoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oveja")
    private Collection<Historialxovejaxcorral> historialxovejaxcorralCollection;
    @OneToMany(mappedBy = "oveja")
    private Collection<Servicio> servicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oveja1")
    private Collection<Servicio> servicioCollection1;

    public Oveja() {
    }

    public Oveja(Integer ovejaid) {
        this.ovejaid = ovejaid;
    }

    public Oveja(Integer ovejaid, int ovejarp, int majadaid, int corralid, Date ovejafechaalta, String ovejasexo, int ovejaedadinicial) {
        this.ovejaid = ovejaid;
        this.ovejarp = ovejarp;
        this.majadaid = majadaid;
        this.corralid = corralid;
        this.ovejafechaalta = ovejafechaalta;
        this.ovejasexo = ovejasexo;
        this.ovejaedadinicial = ovejaedadinicial;
    }

    public Integer getOvejaid() {
        return ovejaid;
    }

    public void setOvejaid(Integer ovejaid) {
        this.ovejaid = ovejaid;
    }

    public int getOvejarp() {
        return ovejarp;
    }

    public void setOvejarp(int ovejarp) {
        this.ovejarp = ovejarp;
    }

    public int getMajadaid() {
        return majadaid;
    }

    public void setMajadaid(int majadaid) {
        this.majadaid = majadaid;
    }

    public int getCorralid() {
        return corralid;
    }

    public void setCorralid(int corralid) {
        this.corralid = corralid;
    }

    public Date getOvejafechaalta() {
        return ovejafechaalta;
    }

    public void setOvejafechaalta(Date ovejafechaalta) {
        this.ovejafechaalta = ovejafechaalta;
    }

    public BigDecimal getOvejapeso() {
        return ovejapeso;
    }

    public void setOvejapeso(BigDecimal ovejapeso) {
        this.ovejapeso = ovejapeso;
    }

    public String getOvejasexo() {
        return ovejasexo;
    }

    public void setOvejasexo(String ovejasexo) {
        this.ovejasexo = ovejasexo;
    }

    public int getOvejaedadinicial() {
        return ovejaedadinicial;
    }

    public void setOvejaedadinicial(int ovejaedadinicial) {
        this.ovejaedadinicial = ovejaedadinicial;
    }

    public Collection<Criaxestadoxparto> getCriaxestadoxpartoCollection() {
        return criaxestadoxpartoCollection;
    }

    public void setCriaxestadoxpartoCollection(Collection<Criaxestadoxparto> criaxestadoxpartoCollection) {
        this.criaxestadoxpartoCollection = criaxestadoxpartoCollection;
    }

    public Collection<Madrexestadoxparto> getMadrexestadoxpartoCollection() {
        return madrexestadoxpartoCollection;
    }

    public void setMadrexestadoxpartoCollection(Collection<Madrexestadoxparto> madrexestadoxpartoCollection) {
        this.madrexestadoxpartoCollection = madrexestadoxpartoCollection;
    }

    public Collection<Historialxovejaxcorral> getHistorialxovejaxcorralCollection() {
        return historialxovejaxcorralCollection;
    }

    public void setHistorialxovejaxcorralCollection(Collection<Historialxovejaxcorral> historialxovejaxcorralCollection) {
        this.historialxovejaxcorralCollection = historialxovejaxcorralCollection;
    }

    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    public Collection<Servicio> getServicioCollection1() {
        return servicioCollection1;
    }

    public void setServicioCollection1(Collection<Servicio> servicioCollection1) {
        this.servicioCollection1 = servicioCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ovejaid != null ? ovejaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oveja)) {
            return false;
        }
        Oveja other = (Oveja) object;
        if ((this.ovejaid == null && other.ovejaid != null) || (this.ovejaid != null && !this.ovejaid.equals(other.ovejaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Oveja[ovejaid=" + ovejaid + "]";
    }

}
