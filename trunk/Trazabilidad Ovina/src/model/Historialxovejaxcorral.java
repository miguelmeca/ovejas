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
@Table(name = "HISTORIALXOVEJAXCORRAL")
@NamedQueries({
    @NamedQuery(name = "Historialxovejaxcorral.findAll", query = "SELECT h FROM Historialxovejaxcorral h"),
    @NamedQuery(name = "Historialxovejaxcorral.findByHistorialxovejaxcorralid", query = "SELECT h FROM Historialxovejaxcorral h WHERE h.historialxovejaxcorralid = :historialxovejaxcorralid"),
    @NamedQuery(name = "Historialxovejaxcorral.findByOvejaxcorralfecha", query = "SELECT h FROM Historialxovejaxcorral h WHERE h.ovejaxcorralfecha = :ovejaxcorralfecha"),
    @NamedQuery(name = "Historialxovejaxcorral.findByOvejaxcorralfechasalida", query = "SELECT h FROM Historialxovejaxcorral h WHERE h.ovejaxcorralfechasalida = :ovejaxcorralfechasalida"),
    @NamedQuery(name = "Historialxovejaxcorral.findByOvejaxcorralfechaentrada", query = "SELECT h FROM Historialxovejaxcorral h WHERE h.ovejaxcorralfechaentrada = :ovejaxcorralfechaentrada")})
public class Historialxovejaxcorral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HISTORIALXOVEJAXCORRALID")
    private Integer historialxovejaxcorralid;
    @Column(name = "OVEJAXCORRALFECHA")
    @Temporal(TemporalType.DATE)
    private Date ovejaxcorralfecha;
    @Column(name = "OVEJAXCORRALFECHASALIDA")
    @Temporal(TemporalType.DATE)
    private Date ovejaxcorralfechasalida;
    @Basic(optional = false)
    @Column(name = "OVEJAXCORRALFECHAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date ovejaxcorralfechaentrada;
    @JoinColumn(name = "OVEJAID", referencedColumnName = "OVEJAID")
    @ManyToOne(optional = false)
    private Oveja oveja;
    @JoinColumn(name = "CORRALID", referencedColumnName = "CORRALID")
    @ManyToOne(optional = false)
    private Corral corral;

    public Historialxovejaxcorral() {
    }

    public Historialxovejaxcorral(Integer historialxovejaxcorralid) {
        this.historialxovejaxcorralid = historialxovejaxcorralid;
    }

    public Historialxovejaxcorral(Integer historialxovejaxcorralid, Date ovejaxcorralfechaentrada) {
        this.historialxovejaxcorralid = historialxovejaxcorralid;
        this.ovejaxcorralfechaentrada = ovejaxcorralfechaentrada;
    }

    public Integer getHistorialxovejaxcorralid() {
        return historialxovejaxcorralid;
    }

    public void setHistorialxovejaxcorralid(Integer historialxovejaxcorralid) {
        this.historialxovejaxcorralid = historialxovejaxcorralid;
    }

    public Date getOvejaxcorralfecha() {
        return ovejaxcorralfecha;
    }

    public void setOvejaxcorralfecha(Date ovejaxcorralfecha) {
        this.ovejaxcorralfecha = ovejaxcorralfecha;
    }

    public Date getOvejaxcorralfechasalida() {
        return ovejaxcorralfechasalida;
    }

    public void setOvejaxcorralfechasalida(Date ovejaxcorralfechasalida) {
        this.ovejaxcorralfechasalida = ovejaxcorralfechasalida;
    }

    public Date getOvejaxcorralfechaentrada() {
        return ovejaxcorralfechaentrada;
    }

    public void setOvejaxcorralfechaentrada(Date ovejaxcorralfechaentrada) {
        this.ovejaxcorralfechaentrada = ovejaxcorralfechaentrada;
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
        hash += (historialxovejaxcorralid != null ? historialxovejaxcorralid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialxovejaxcorral)) {
            return false;
        }
        Historialxovejaxcorral other = (Historialxovejaxcorral) object;
        if ((this.historialxovejaxcorralid == null && other.historialxovejaxcorralid != null) || (this.historialxovejaxcorralid != null && !this.historialxovejaxcorralid.equals(other.historialxovejaxcorralid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Historialxovejaxcorral[historialxovejaxcorralid=" + historialxovejaxcorralid + "]";
    }

}
