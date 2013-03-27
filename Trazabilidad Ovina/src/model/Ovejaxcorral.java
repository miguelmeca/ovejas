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
@Table(name = "OVEJAXCORRAL")
@NamedQueries({
    @NamedQuery(name = "Ovejaxcorral.findAll", query = "SELECT o FROM Ovejaxcorral o"),
    @NamedQuery(name = "Ovejaxcorral.findByOvejaxcorralid", query = "SELECT o FROM Ovejaxcorral o WHERE o.ovejaxcorralid = :ovejaxcorralid"),
    @NamedQuery(name = "Ovejaxcorral.findByOvejaxcorralfechasalida", query = "SELECT o FROM Ovejaxcorral o WHERE o.ovejaxcorralfechasalida = :ovejaxcorralfechasalida")})
public class Ovejaxcorral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OVEJAXCORRALID")
    private Integer ovejaxcorralid;
    @Column(name = "OVEJAXCORRALFECHASALIDA")
    @Temporal(TemporalType.DATE)
    private Date ovejaxcorralfechasalida;
    @JoinColumn(name = "OVEJAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja;
    @JoinColumn(name = "CORRALID", referencedColumnName = "CORRALID")
    @ManyToOne(optional = false)
    private Corral corral;

    public Ovejaxcorral() {
    }

    public Ovejaxcorral(Integer ovejaxcorralid) {
        this.ovejaxcorralid = ovejaxcorralid;
    }

    public Integer getOvejaxcorralid() {
        return ovejaxcorralid;
    }

    public void setOvejaxcorralid(Integer ovejaxcorralid) {
        this.ovejaxcorralid = ovejaxcorralid;
    }

    public Date getOvejaxcorralfechasalida() {
        return ovejaxcorralfechasalida;
    }

    public void setOvejaxcorralfechasalida(Date ovejaxcorralfechasalida) {
        this.ovejaxcorralfechasalida = ovejaxcorralfechasalida;
    }

    public Oveja getOveja() {
        return oveja;
    }

    public void setOveja(Oveja oveja) {
        this.oveja = oveja;
    }

    public Corral getCorral() {
        return corral;
    }

    public void setCorral(Corral corral) {
        this.corral = corral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ovejaxcorralid != null ? ovejaxcorralid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ovejaxcorral)) {
            return false;
        }
        Ovejaxcorral other = (Ovejaxcorral) object;
        if ((this.ovejaxcorralid == null && other.ovejaxcorralid != null) || (this.ovejaxcorralid != null && !this.ovejaxcorralid.equals(other.ovejaxcorralid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ovejaxcorral[ovejaxcorralid=" + ovejaxcorralid + "]";
    }

}
