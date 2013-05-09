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
@Table(name = "CRIAXESTADOXPARTO")
@NamedQueries({
    @NamedQuery(name = "Criaxestadoxparto.findAll", query = "SELECT c FROM Criaxestadoxparto c"),
    @NamedQuery(name = "Criaxestadoxparto.findByCriaxestadoxpartoid", query = "SELECT c FROM Criaxestadoxparto c WHERE c.criaxestadoxpartoid = :criaxestadoxpartoid"),
    @NamedQuery(name = "Criaxestadoxparto.findByCriaxestadoxpartofecharegistro", query = "SELECT c FROM Criaxestadoxparto c WHERE c.criaxestadoxpartofecharegistro = :criaxestadoxpartofecharegistro")})
public class Criaxestadoxparto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CRIAXESTADOXPARTOID")
    private Integer criaxestadoxpartoid;
    @Basic(optional = false)
    @Column(name = "CRIAXESTADOXPARTOFECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date criaxestadoxpartofecharegistro;
    @JoinColumn(name = "PARTOID", referencedColumnName = "PARTOID")
    @ManyToOne(optional = false)
    private Parto parto;
    @JoinColumn(name = "OVEJAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja;
    @JoinColumn(name = "ESTADOID", referencedColumnName = "ESTADOID")
    @ManyToOne(optional = false)
    private Estado estado;

    public Criaxestadoxparto() {
    }

    public Criaxestadoxparto(Integer criaxestadoxpartoid) {
        this.criaxestadoxpartoid = criaxestadoxpartoid;
    }

    public Criaxestadoxparto(Integer criaxestadoxpartoid, Date criaxestadoxpartofecharegistro) {
        this.criaxestadoxpartoid = criaxestadoxpartoid;
        this.criaxestadoxpartofecharegistro = criaxestadoxpartofecharegistro;
    }

    public Integer getCriaxestadoxpartoid() {
        return criaxestadoxpartoid;
    }

    public void setCriaxestadoxpartoid(Integer criaxestadoxpartoid) {
        this.criaxestadoxpartoid = criaxestadoxpartoid;
    }

    public Date getCriaxestadoxpartofecharegistro() {
        return criaxestadoxpartofecharegistro;
    }

    public void setCriaxestadoxpartofecharegistro(Date criaxestadoxpartofecharegistro) {
        this.criaxestadoxpartofecharegistro = criaxestadoxpartofecharegistro;
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
        hash += (criaxestadoxpartoid != null ? criaxestadoxpartoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criaxestadoxparto)) {
            return false;
        }
        Criaxestadoxparto other = (Criaxestadoxparto) object;
        if ((this.criaxestadoxpartoid == null && other.criaxestadoxpartoid != null) || (this.criaxestadoxpartoid != null && !this.criaxestadoxpartoid.equals(other.criaxestadoxpartoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Criaxestadoxparto[criaxestadoxpartoid=" + criaxestadoxpartoid + "]";
    }

}
