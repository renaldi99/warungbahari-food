package com.example.warungbahari.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Table(name = "trx_purchase")
public class Purchase {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "purchase_id")
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPurchase;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // purchase detail mapped by purchase (di mapping oleh purchase itu sendiri)
    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetails> purchaseDetails = new ArrayList<>();
}
