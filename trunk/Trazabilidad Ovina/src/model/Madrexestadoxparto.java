/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author laura
 */
@Entity
@Table(name = "MADREXESTADOXPARTO")
@NamedQueries({
    @NamedQuery(name = "Madrexestadoxparto.findAll", query = "SELECT m FROM Madrexestadoxparto m"),
    @NamedQuery(name = "Madrexestadoxparto.findByMadrexestadoxpartoid", query = "SELECT m FROM Madrexestadoxparto m WHERE m.madrexestadoxpartoid = :madrexestadoxpartoid"),
    @NamedQuery(name = "Madrexestadoxparto.findByMadrexestadoxpartofecharegistro", query = "SELECT m FROM Madrexestadoxparto m WHERE m.madrexestadoxpartofecharegistro = :madrexestadoxpartofecharegistro")})
public class Madrexestadoxparto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MADREXESTADOXPARTOID")
    private Integer madrexestadoxpartoid;
    @Basic(optional = false)
    @Column(name = "MADREXESTADOXPARTOFECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date madrexestadoxpartofecharegistro;
    @JoinColumn(name = "PARTOID", referencedColumnName = "PARTOID")
    @ManyToOne(optional = false)
    private Parto parto;
    @JoinColumn(name = "OVEJAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja;
    @JoinColumn(name = "ESTADOID", referencedColumnName = "ESTADOID")
    @ManyToOne(optional = false)
    private Estado estado;

    public Madrexestadoxparto() {
    }

    public Madrexestadoxparto(Integer madrexestadoxpartoid) {
        this.madrexestadoxpartoid = madrexestadoxpartoid;
    }

    public Madrexestadoxparto(Integer madrexestadoxpartoid, Date madrexestadoxpartofecharegistro) {
        this.madrexestadoxpartoid = madrexestadoxpartoid;
        this.madrexestadoxpartofecharegistro = madrexestadoxpartofecharegistro;
    }

    public Integer getMadrexestadoxpartoid() {
        return madrexestadoxpartoid;
    }

    public void setMadrexestadoxpartoid(Integer madrexestadoxpartoid) {
        this.madrexestadoxpartoid = madrexestadoxpartoid;
    }

    public Date getMadrexestadoxpartofecharegistro() {
        return madrexestadoxpartofecharegistro;
    }

    public void setMadrexestadoxpartofecharegistro(Date madrexestadoxpartofecharegistro) {
        this.madrexestadoxpartofecharegistro = madrexestadoxpartofecharegistro;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (madrexestadoxpartoid != null ? madrexestadoxpartoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Madrexestadoxparto)) {
            return false;
        }
        Madrexestadoxparto other = (Madrexestadoxparto) object;
        if ((this.madrexestadoxpartoid == null && other.madrexestadoxpartoid != null) || (this.madrexestadoxpartoid != null && !this.madrexestadoxpartoid.equals(other.madrexestadoxpartoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Madrexestadoxparto[madrexestadoxpartoid=" + madrexestadoxpartoid + "]";
    }

}
