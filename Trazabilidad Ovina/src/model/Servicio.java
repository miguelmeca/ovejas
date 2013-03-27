/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "SERVICIO")
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByServicioid", query = "SELECT s FROM Servicio s WHERE s.servicioid = :servicioid"),
    @NamedQuery(name = "Servicio.findByServiciofecha", query = "SELECT s FROM Servicio s WHERE s.serviciofecha = :serviciofecha"),
    @NamedQuery(name = "Servicio.findByServicioexito", query = "SELECT s FROM Servicio s WHERE s.servicioexito = :servicioexito")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICIOID")
    private Integer servicioid;
    @Basic(optional = false)
    @Column(name = "SERVICIOFECHA")
    @Temporal(TemporalType.DATE)
    private Date serviciofecha;
    @Column(name = "SERVICIOEXITO")
    private Serializable servicioexito;
    @JoinColumn(name = "OVEJAMACHOID", referencedColumnName = "OVEJAID")
    @ManyToOne
    private Oveja oveja;
    @JoinColumn(name = "OVEJAHEMBRAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja1;
    @OneToMany(mappedBy = "servicio")
    private Collection<Preniez> preniezCollection;

    public Servicio() {
    }

    public Servicio(Integer servicioid) {
        this.servicioid = servicioid;
    }

    public Servicio(Integer servicioid, Date serviciofecha) {
        this.servicioid = servicioid;
        this.serviciofecha = serviciofecha;
    }

    public Integer getServicioid() {
        return servicioid;
    }

    public void setServicioid(Integer servicioid) {
        this.servicioid = servicioid;
    }

    public Date getServiciofecha() {
        return serviciofecha;
    }

    public void setServiciofecha(Date serviciofecha) {
        this.serviciofecha = serviciofecha;
    }

    public Serializable getServicioexito() {
        return servicioexito;
    }

    public void setServicioexito(Serializable servicioexito) {
        this.servicioexito = servicioexito;
    }

    public Oveja getOveja() {
        return oveja;
    }

    public void setOveja(Oveja oveja) {
        this.oveja = oveja;
    }

    public Oveja getOveja1() {
        return oveja1;
    }

    public void setOveja1(Oveja oveja1) {
        this.oveja1 = oveja1;
    }

    public Collection<Preniez> getPreniezCollection() {
        return preniezCollection;
    }

    public void setPreniezCollection(Collection<Preniez> preniezCollection) {
        this.preniezCollection = preniezCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioid != null ? servicioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.servicioid == null && other.servicioid != null) || (this.servicioid != null && !this.servicioid.equals(other.servicioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Servicio[servicioid=" + servicioid + "]";
    }

}
