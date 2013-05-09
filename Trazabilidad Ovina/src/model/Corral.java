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
@Table(name = "CORRAL")
@NamedQueries({
    @NamedQuery(name = "Corral.findAll", query = "SELECT c FROM Corral c"),
    @NamedQuery(name = "Corral.findByCorralid", query = "SELECT c FROM Corral c WHERE c.corralid = :corralid"),
    @NamedQuery(name = "Corral.findByCorralnombre", query = "SELECT c FROM Corral c WHERE c.corralnombre = :corralnombre"),
    @NamedQuery(name = "Corral.findByCorraldescripcion", query = "SELECT c FROM Corral c WHERE c.corraldescripcion = :corraldescripcion"),
    @NamedQuery(name = "Corral.findByCorralcapacidad", query = "SELECT c FROM Corral c WHERE c.corralcapacidad = :corralcapacidad")})
public class Corral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CORRALID")
    private Integer corralid;
    @Basic(optional = false)
    @Column(name = "CORRALNOMBRE")
    private String corralnombre;
    @Column(name = "CORRALDESCRIPCION")
    private String corraldescripcion;
    @Column(name = "CORRALCAPACIDAD")
    private Integer corralcapacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corral")
    private Collection<Historialxovejaxcorral> historialxovejaxcorralCollection;

    public Corral() {
    }

    public Corral(Integer corralid) {
        this.corralid = corralid;
    }

    public Corral(Integer corralid, String corralnombre) {
        this.corralid = corralid;
        this.corralnombre = corralnombre;
    }

    public Integer getCorralid() {
        return corralid;
    }

    public void setCorralid(Integer corralid) {
        this.corralid = corralid;
    }

    public String getCorralnombre() {
        return corralnombre;
    }

    public void setCorralnombre(String corralnombre) {
        this.corralnombre = corralnombre;
    }

    public String getCorraldescripcion() {
        return corraldescripcion;
    }

    public void setCorraldescripcion(String corraldescripcion) {
        this.corraldescripcion = corraldescripcion;
    }

    public Integer getCorralcapacidad() {
        return corralcapacidad;
    }

    public void setCorralcapacidad(Integer corralcapacidad) {
        this.corralcapacidad = corralcapacidad;
    }

    public Collection<Historialxovejaxcorral> getHistorialxovejaxcorralCollection() {
        return historialxovejaxcorralCollection;
    }

    public void setHistorialxovejaxcorralCollection(Collection<Historialxovejaxcorral> historialxovejaxcorralCollection) {
        this.historialxovejaxcorralCollection = historialxovejaxcorralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corralid != null ? corralid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corral)) {
            return false;
        }
        Corral other = (Corral) object;
        if ((this.corralid == null && other.corralid != null) || (this.corralid != null && !this.corralid.equals(other.corralid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Corral[corralid=" + corralid + "]";
    }

}
