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
@Table(name = "ESTADO")
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByEstadoid", query = "SELECT e FROM Estado e WHERE e.estadoid = :estadoid"),
    @NamedQuery(name = "Estado.findByEstadonombre", query = "SELECT e FROM Estado e WHERE e.estadonombre = :estadonombre"),
    @NamedQuery(name = "Estado.findByEstadodescripcion", query = "SELECT e FROM Estado e WHERE e.estadodescripcion = :estadodescripcion")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTADOID")
    private Integer estadoid;
    @Basic(optional = false)
    @Column(name = "ESTADONOMBRE")
    private String estadonombre;
    @Basic(optional = false)
    @Column(name = "ESTADODESCRIPCION")
    private int estadodescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Criaxestadoxparto> criaxestadoxpartoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Madrexestadoxparto> madrexestadoxpartoCollection;

    public Estado() {
    }

    public Estado(Integer estadoid) {
        this.estadoid = estadoid;
    }

    public Estado(Integer estadoid, String estadonombre, int estadodescripcion) {
        this.estadoid = estadoid;
        this.estadonombre = estadonombre;
        this.estadodescripcion = estadodescripcion;
    }

    public Integer getEstadoid() {
        return estadoid;
    }

    public void setEstadoid(Integer estadoid) {
        this.estadoid = estadoid;
    }

    public String getEstadonombre() {
        return estadonombre;
    }

    public void setEstadonombre(String estadonombre) {
        this.estadonombre = estadonombre;
    }

    public int getEstadodescripcion() {
        return estadodescripcion;
    }

    public void setEstadodescripcion(int estadodescripcion) {
        this.estadodescripcion = estadodescripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoid != null ? estadoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoid == null && other.estadoid != null) || (this.estadoid != null && !this.estadoid.equals(other.estadoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estado[estadoid=" + estadoid + "]";
    }

}
