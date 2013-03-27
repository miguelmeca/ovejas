/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author laura
 */
@Entity
@Table(name = "ESTADOPARTO")
@NamedQueries({
    @NamedQuery(name = "Estadoparto.findAll", query = "SELECT e FROM Estadoparto e"),
    @NamedQuery(name = "Estadoparto.findByEstadopartoid", query = "SELECT e FROM Estadoparto e WHERE e.estadopartoid = :estadopartoid"),
    @NamedQuery(name = "Estadoparto.findByEstadodescripcion", query = "SELECT e FROM Estadoparto e WHERE e.estadodescripcion = :estadodescripcion")})
public class Estadoparto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTADOPARTOID")
    private Integer estadopartoid;
    @Basic(optional = false)
    @Column(name = "ESTADODESCRIPCION")
    private int estadodescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoparto")
    private Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollection;

    public Estadoparto() {
    }

    public Estadoparto(Integer estadopartoid) {
        this.estadopartoid = estadopartoid;
    }

    public Estadoparto(Integer estadopartoid, int estadodescripcion) {
        this.estadopartoid = estadopartoid;
        this.estadodescripcion = estadodescripcion;
    }

    public Integer getEstadopartoid() {
        return estadopartoid;
    }

    public void setEstadopartoid(Integer estadopartoid) {
        this.estadopartoid = estadopartoid;
    }

    public int getEstadodescripcion() {
        return estadodescripcion;
    }

    public void setEstadodescripcion(int estadodescripcion) {
        this.estadodescripcion = estadodescripcion;
    }

    public Collection<Estadopartoxpartoxoveja> getEstadopartoxpartoxovejaCollection() {
        return estadopartoxpartoxovejaCollection;
    }

    public void setEstadopartoxpartoxovejaCollection(Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollection) {
        this.estadopartoxpartoxovejaCollection = estadopartoxpartoxovejaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadopartoid != null ? estadopartoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoparto)) {
            return false;
        }
        Estadoparto other = (Estadoparto) object;
        if ((this.estadopartoid == null && other.estadopartoid != null) || (this.estadopartoid != null && !this.estadopartoid.equals(other.estadopartoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estadoparto[estadopartoid=" + estadopartoid + "]";
    }

}
