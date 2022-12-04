package de.nag2548.debitor.server.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PaymentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Account payer;

    @OneToMany(mappedBy = "paymentGroup", cascade = CascadeType.ALL)
    private Set<Debitor> debitors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getPayer() {
        return payer;
    }

    public void setPayer(Account payer) {
        this.payer = payer;
    }

    public Set<Debitor> getDebitors() {
        return debitors;
    }

    public void setDebitors(Set<Debitor> debitors) {
        this.debitors = debitors;
    }
}
