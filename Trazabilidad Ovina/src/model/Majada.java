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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "MAJADA")
@NamedQueries({
    @NamedQuery(name = "Majada.findAll", query = "SELECT m FROM Majada m"),
    @NamedQuery(name = "Majada.findByMajadaid", query = "SELECT m FROM Majada m WHERE m.majadaid = :majadaid"),
    @NamedQuery(name = "Majada.findByMajadanombre", query = "SELECT m FROM Majada m WHERE m.majadanombre = :majadanombre"),
    @NamedQuery(name = "Majada.findByMajadadescripcion", query = "SELECT m FROM Majada m WHERE m.majadadescripcion = :majadadescripcion")})
public class Majada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAJADAID")
    private Integer majadaid;
    @Basic(optional = false)
    @Column(name = "MAJADANOMBRE")
    private String majadanombre;
    @Column(name = "MAJADADESCRIPCION")
    private String majadadescripcion;

    public Majada() {
    }

    public Majada(Integer majadaid) {
        this.majadaid = majadaid;
    }

    public Majada(Integer majadaid, String majadanombre) {
        this.majadaid = majadaid;
        this.majadanombre = majadanombre;
    }

    public Integer getMajadaid() {
        return majadaid;
    }

    public void setMajadaid(Integer majadaid) {
        this.majadaid = majadaid;
    }

    public String getMajadanombre() {
        return majadanombre;
    }

    public void setMajadanombre(String majadanombre) {
        this.majadanombre = majadanombre;
    }

    public String getMajadadescripcion() {
        return majadadescripcion;
    }

    public void setMajadadescripcion(String majadadescripcion) {
        this.majadadescripcion = majadadescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (majadaid != null ? majadaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Majada)) {
            return false;
        }
        Majada other = (Majada) object;
        if ((this.majadaid == null && other.majadaid != null) || (this.majadaid != null && !this.majadaid.equals(other.majadaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Majada[majadaid=" + majadaid + "]";
    }

}
