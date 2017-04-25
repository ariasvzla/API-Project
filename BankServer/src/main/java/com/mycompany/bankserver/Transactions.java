/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankserver;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    , @NamedQuery(name = "Transactions.findByTargetaccountnumber", query = "SELECT t FROM Transactions t WHERE t.targetaccountnumber = :targetaccountnumber")
    , @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date")
    , @NamedQuery(name = "Transactions.findByBalance", query = "SELECT t FROM Transactions t WHERE t.balance = :balance")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trid")
    private Integer trid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Size(max = 20)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "targetaccountnumber")
    private String targetaccountnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @JoinColumn(name = "accounts_accountid", referencedColumnName = "accountid")
    @ManyToOne(optional = false)
    private Accounts accountsAccountid;

    public Transactions() {
    }

    public Transactions(Integer trid) {
        this.trid = trid;
    }

    public Transactions(Integer trid, String type, String targetaccountnumber, double amount) {
        this.trid = trid;
        this.type = type;
        this.targetaccountnumber = targetaccountnumber;
        this.amount = amount;
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

    public String getTargetaccountnumber() {
        return targetaccountnumber;
    }

    public void setTargetaccountnumber(String targetaccountnumber) {
        this.targetaccountnumber = targetaccountnumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
        return "com.mycompany.bankserver.Transactions[ trid=" + trid + " ]";
    }
    
}
