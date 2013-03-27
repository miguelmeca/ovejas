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
@Table(name = "PRENIEZ")
@NamedQueries({
    @NamedQuery(name = "Preniez.findAll", query = "SELECT p FROM Preniez p"),
    @NamedQuery(name = "Preniez.findByPreniezid", query = "SELECT p FROM Preniez p WHERE p.preniezid = :preniezid"),
    @NamedQuery(name = "Preniez.findByPreniezfechaposibleparto", query = "SELECT p FROM Preniez p WHERE p.preniezfechaposibleparto = :preniezfechaposibleparto"),
    @NamedQuery(name = "Preniez.findByPreniezcantidadembriones", query = "SELECT p FROM Preniez p WHERE p.preniezcantidadembriones = :preniezcantidadembriones")})
public class Preniez implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRENIEZID")
    private Integer preniezid;
    @Column(name = "PRENIEZFECHAPOSIBLEPARTO")
    @Temporal(TemporalType.DATE)
    private Date preniezfechaposibleparto;
    @Column(name = "PRENIEZCANTIDADEMBRIONES")
    private Integer preniezcantidadembriones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preniez")
    private Collection<Parto> partoCollection;
    @JoinColumn(name = "SERVICIOID", referencedColumnName = "SERVICIOID")
    @ManyToOne
    private Servicio servicio;

    public Preniez() {
    }

    public Preniez(Integer preniezid) {
        this.preniezid = preniezid;
    }

    public Integer getPreniezid() {
        return preniezid;
    }

    public void setPreniezid(Integer preniezid) {
        this.preniezid = preniezid;
    }

    public Date getPreniezfechaposibleparto() {
        return preniezfechaposibleparto;
    }

    public void setPreniezfechaposibleparto(Date preniezfechaposibleparto) {
        this.preniezfechaposibleparto = preniezfechaposibleparto;
    }

    public Integer getPreniezcantidadembriones() {
        return preniezcantidadembriones;
    }

    public void setPreniezcantidadembriones(Integer preniezcantidadembriones) {
        this.preniezcantidadembriones = preniezcantidadembriones;
    }

    public Collection<Parto> getPartoCollection() {
        return partoCollection;
    }

    public void setPartoCollection(Collection<Parto> partoCollection) {
        this.partoCollection = partoCollection;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preniezid != null ? preniezid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preniez)) {
            return false;
        }
        Preniez other = (Preniez) object;
        if ((this.preniezid == null && other.preniezid != null) || (this.preniezid != null && !this.preniezid.equals(other.preniezid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Preniez[preniezid=" + preniezid + "]";
    }

}
