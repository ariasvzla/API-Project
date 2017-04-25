/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
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
    , @NamedQuery(name = "Accounts.findByAccountnumber", query = "SELECT a FROM Accounts a WHERE a.accountnumber = :accountnumber")
    , @NamedQuery(name = "Accounts.findBySortcode", query = "SELECT a FROM Accounts a WHERE a.sortcode = :sortcode")
    , @NamedQuery(name = "Accounts.findByBalance", query = "SELECT a FROM Accounts a WHERE a.balance = :balance")})
public class Accounts implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountid")
    private Integer accountid;
    @Column(name = "accountnumber")
    private String accountnumber;
    @Column(name = "sortcode")
    private Integer sortcode;
    @Column(name = "balance")
    private double balance;
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

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        Integer oldAccountid = this.accountid;
        this.accountid = accountid;
        changeSupport.firePropertyChange("accountid", oldAccountid, accountid);
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        String oldAccountnumber = this.accountnumber;
        this.accountnumber = accountnumber;
        changeSupport.firePropertyChange("accountnumber", oldAccountnumber, accountnumber);
    }

    public Integer getSortcode() {
        return sortcode;
    }

    public void setSortcode(Integer sortcode) {
        Integer oldSortcode = this.sortcode;
        this.sortcode = sortcode;
        changeSupport.firePropertyChange("sortcode", oldSortcode, sortcode);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        double oldBalance = this.balance;
        this.balance = balance;
        changeSupport.firePropertyChange("balance", oldBalance, balance);
    }

    public Branch getBranchBranchid() {
        return branchBranchid;
    }

    public void setBranchBranchid(Branch branchBranchid) {
        Branch oldBranchBranchid = this.branchBranchid;
        this.branchBranchid = branchBranchid;
        changeSupport.firePropertyChange("branchBranchid", oldBranchBranchid, branchBranchid);
    }

    public Customer getCustomerCustid() {
        return customerCustid;
    }

    public void setCustomerCustid(Customer customerCustid) {
        Customer oldCustomerCustid = this.customerCustid;
        this.customerCustid = customerCustid;
        changeSupport.firePropertyChange("customerCustid", oldCustomerCustid, customerCustid);
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
        return "entity.Accounts[ accountid=" + accountid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }


}
