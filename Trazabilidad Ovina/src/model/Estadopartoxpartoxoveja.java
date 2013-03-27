/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "ESTADOPARTOXPARTOXOVEJA")
@NamedQueries({
    @NamedQuery(name = "Estadopartoxpartoxoveja.findAll", query = "SELECT e FROM Estadopartoxpartoxoveja e"),
    @NamedQuery(name = "Estadopartoxpartoxoveja.findByEstadopartoxpartoxovejaid", query = "SELECT e FROM Estadopartoxpartoxoveja e WHERE e.estadopartoxpartoxovejaid = :estadopartoxpartoxovejaid"),
    @NamedQuery(name = "Estadopartoxpartoxoveja.findByEstadoxpartoxpartoxovejaesmadre", query = "SELECT e FROM Estadopartoxpartoxoveja e WHERE e.estadoxpartoxpartoxovejaesmadre = :estadoxpartoxpartoxovejaesmadre")})
public class Estadopartoxpartoxoveja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTADOPARTOXPARTOXOVEJAID")
    private Integer estadopartoxpartoxovejaid;
    @Basic(optional = false)
    @Column(name = "ESTADOXPARTOXPARTOXOVEJAESMADRE")
    private Serializable estadoxpartoxpartoxovejaesmadre;
    @JoinColumn(name = "PARTOID", referencedColumnName = "PARTOID")
    @ManyToOne(optional = false)
    private Parto parto;
    @JoinColumn(name = "OVEJAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja;
    @JoinColumn(name = "ESTADOPARTOID", referencedColumnName = "ESTADOPARTOID")
    @ManyToOne(optional = false)
    private Estadoparto estadoparto;

    public Estadopartoxpartoxoveja() {
    }

    public Estadopartoxpartoxoveja(Integer estadopartoxpartoxovejaid) {
        this.estadopartoxpartoxovejaid = estadopartoxpartoxovejaid;
    }

    public Estadopartoxpartoxoveja(Integer estadopartoxpartoxovejaid, Serializable estadoxpartoxpartoxovejaesmadre) {
        this.estadopartoxpartoxovejaid = estadopartoxpartoxovejaid;
        this.estadoxpartoxpartoxovejaesmadre = estadoxpartoxpartoxovejaesmadre;
    }

    public Integer getEstadopartoxpartoxovejaid() {
        return estadopartoxpartoxovejaid;
    }

    public void setEstadopartoxpartoxovejaid(Integer estadopartoxpartoxovejaid) {
        this.estadopartoxpartoxovejaid = estadopartoxpartoxovejaid;
    }

    public Serializable getEstadoxpartoxpartoxovejaesmadre() {
        return estadoxpartoxpartoxovejaesmadre;
    }

    public void setEstadoxpartoxpartoxovejaesmadre(Serializable estadoxpartoxpartoxovejaesmadre) {
        this.estadoxpartoxpartoxovejaesmadre = estadoxpartoxpartoxovejaesmadre;
    }

    public Parto getParto() {
        return parto;
    }

    public void setParto(Parto parto) {
        this.parto = parto;
    }

    public Oveja getOveja() {
        return oveja;
    }

    public void setOveja(Oveja oveja) {
        this.oveja = oveja;
    }

    public Estadoparto getEstadoparto() {
        return estadoparto;
    }

    public void setEstadoparto(Estadoparto estadoparto) {
        this.estadoparto = estadoparto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadopartoxpartoxovejaid != null ? estadopartoxpartoxovejaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopartoxpartoxoveja)) {
            return false;
        }
        Estadopartoxpartoxoveja other = (Estadopartoxpartoxoveja) object;
        if ((this.estadopartoxpartoxovejaid == null && other.estadopartoxpartoxovejaid != null) || (this.estadopartoxpartoxovejaid != null && !this.estadopartoxpartoxovejaid.equals(other.estadopartoxpartoxovejaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estadopartoxpartoxoveja[estadopartoxpartoxovejaid=" + estadopartoxpartoxovejaid + "]";
    }

}
