/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PARTO")
@NamedQueries({
    @NamedQuery(name = "Parto.findAll", query = "SELECT p FROM Parto p"),
    @NamedQuery(name = "Parto.findByPartoid", query = "SELECT p FROM Parto p WHERE p.partoid = :partoid"),
    @NamedQuery(name = "Parto.findByPartofecha", query = "SELECT p FROM Parto p WHERE p.partofecha = :partofecha"),
    @NamedQuery(name = "Parto.findByPartoobservacion", query = "SELECT p FROM Parto p WHERE p.partoobservacion = :partoobservacion")})
public class Parto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARTOID")
    private Integer partoid;
    @Basic(optional = false)
    @Column(name = "PARTOFECHA")
    @Temporal(TemporalType.DATE)
    private Date partofecha;
    @Column(name = "PARTOOBSERVACION")
    private String partoobservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parto")
    private Collection<Criaxestadoxparto> criaxestadoxpartoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parto")
    private Collection<Madrexestadoxparto> madrexestadoxpartoCollection;
    @JoinColumn(name = "PRENIEZID", referencedColumnName = "PRENIEZID")
    @ManyToOne
    private Preniez preniez;

    public Parto() {
    }

    public Parto(Integer partoid) {
        this.partoid = partoid;
    }

    public Parto(Integer partoid, Date partofecha) {
        this.partoid = partoid;
        this.partofecha = partofecha;
    }

    public Integer getPartoid() {
        return partoid;
    }

    public void setPartoid(Integer partoid) {
        this.partoid = partoid;
    }

    public Date getPartofecha() {
        return partofecha;
    }

    public void setPartofecha(Date partofecha) {
        this.partofecha = partofecha;
    }

    public String getPartoobservacion() {
        return partoobservacion;
    }

    public void setPartoobservacion(String partoobservacion) {
        this.partoobservacion = partoobservacion;
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

    public Preniez getPreniez() {
        return preniez;
    }

    public void setPreniez(Preniez preniez) {
        this.preniez = preniez;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partoid != null ? partoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parto)) {
            return false;
        }
        Parto other = (Parto) object;
        if ((this.partoid == null && other.partoid != null) || (this.partoid != null && !this.partoid.equals(other.partoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Parto[partoid=" + partoid + "]";
    }

}
