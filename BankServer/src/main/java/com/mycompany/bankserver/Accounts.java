/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankserver;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alzn-
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccountid", query = "SELECT a FROM Accounts a WHERE a.accountid = :accountid")
    , @NamedQuery(name = "Accounts.findByAccounttype", query = "SELECT a FROM Accounts a WHERE a.accounttype = :accounttype")
    , @NamedQuery(name = "Accounts.findByAccountnumber", query = "SELECT a FROM Accounts a WHERE a.accountnumber = :accountnumber")
    , @NamedQuery(name = "Accounts.findBySortcode", query = "SELECT a FROM Accounts a WHERE a.sortcode = :sortcode")
    , @NamedQuery(name = "Accounts.findByBalance", query = "SELECT a FROM Accounts a WHERE a.balance = :balance")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountid")
    private Integer accountid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accounttype")
    private String accounttype;
    @Size(max = 20)
    @Column(name = "accountnumber")
    private String accountnumber;
    @Column(name = "sortcode")
    private Integer sortcode;
    @Column(name = "balance")
    private Long balance;
    @JoinColumn(name = "branch_branchid", referencedColumnName = "branchid")
    @ManyToOne(optional = false)
    private Branch branchBranchid;
    @JoinColumn(name = "customer_custid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer customerCustid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountsAccountid")
    private Collection<Transactions> transactionsCollection;

    public Accounts() {
    }

    public Accounts(Integer accountid) {
        this.accountid = accountid;
    }

    public Accounts(Integer accountid, String accounttype) {
        this.accountid = accountid;
        this.accounttype = accounttype;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Integer getSortcode() {
        return sortcode;
    }

    public void setSortcode(Integer sortcode) {
        this.sortcode = sortcode;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Branch getBranchBranchid() {
        return branchBranchid;
    }

    public void setBranchBranchid(Branch branchBranchid) {
        this.branchBranchid = branchBranchid;
    }

    public Customer getCustomerCustid() {
        return customerCustid;
    }

    public void setCustomerCustid(Customer customerCustid) {
        this.customerCustid = customerCustid;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountid != null ? accountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountid == null && other.accountid != null) || (this.accountid != null && !this.accountid.equals(other.accountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bankserver.Accounts[ accountid=" + accountid + " ]";
    }
    
}
