/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alzn-
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTrid", query = "SELECT t FROM Transactions t WHERE t.trid = :trid")
    , @NamedQuery(name = "Transactions.findByType", query = "SELECT t FROM Transactions t WHERE t.type = :type")
    , @NamedQuery(name = "Transactions.findByDescription", query = "SELECT t FROM Transactions t WHERE t.description = :description")
    , @NamedQuery(name = "Transactions.findByMoney", query = "SELECT t FROM Transactions t WHERE t.money = :money")
    , @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trid")
    private Integer trid;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "money")
    private Integer money;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "accounts_accountid", referencedColumnName = "accountid")
    @ManyToOne(optional = false)
    private Accounts accountsAccountid;

    public Transactions() {
    }

    public Transactions(Integer trid) {
        this.trid = trid;
    }

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Accounts getAccountsAccountid() {
        return accountsAccountid;
    }

    public void setAccountsAccountid(Accounts accountsAccountid) {
        this.accountsAccountid = accountsAccountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trid != null ? trid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.trid == null && other.trid != null) || (this.trid != null && !this.trid.equals(other.trid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Transactions[ trid=" + trid + " ]";
    }
    
}
